package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.exception.BadCredentialsException;
import com.nixvoid.memoamautas.exception.UserDisabledException;
import com.nixvoid.memoamautas.exception.UserNotFoundException;
import com.nixvoid.memoamautas.service.UserService;
import com.nixvoid.memoamautas.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest){
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword()));
        }catch (DisabledException e){
            throw new UserDisabledException("User not enabled");
        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new BadCredentialsException("Bad credentials");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String jwt=this.jwtUtil.generateToken(userDetails);

        LoginResponse response = new LoginResponse();
        response.setDetails(userDetails);
        response.setJwt(jwt);

        return response;
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @PostMapping(value = "/forgot")
    public LoginRequest forgotPassword(@RequestBody LoginRequest request){
        if(!userService.verifyUserExists(request.getUsername())){
            throw new UserNotFoundException("USER_NOT_FOUND");
        }
        return userService.ForgetPassword(request);
    }
}
