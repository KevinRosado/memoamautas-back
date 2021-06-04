package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.domain.UserDetailsImpl;
import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.exception.UserNotFoundException;
import com.nixvoid.memoamautas.service.UserService;
import com.nixvoid.memoamautas.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/memo", consumes = "application/json;charset=utf-8")
public class UserController {
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Qualifier("CoreAuthenticationManager")
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authmanager = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authmanager);
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String jwt = this.jwtUtil.generateToken(userDetails);
        LoginResponse response = new LoginResponse();
        response.setUsername(userDetails.getUsername());
        response.setEmail(userDetails.getEmail());
        response.setRoles(userDetails.getAuthorities().stream()
                .map(role-> role.getAuthority())
                .collect(Collectors.toList()));
        response.setExpiresIn(this.jwtUtil.getExpirationTime());
        response.setJwt(jwt);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @PostMapping(value = "/forgot")
    public LoginRequest forgotPassword(@RequestBody LoginRequest request){
        if(!userService.verifyUserExists(request.getEmail())){
            throw new UserNotFoundException("USER_NOT_FOUND");
        }
        return userService.ForgetPassword(request);
    }
}
