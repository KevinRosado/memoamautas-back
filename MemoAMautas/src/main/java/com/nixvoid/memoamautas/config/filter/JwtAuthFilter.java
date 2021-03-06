package com.nixvoid.memoamautas.config.filter;

import com.nixvoid.memoamautas.service.impl.UserDetailsServiceImpl;
import com.nixvoid.memoamautas.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.nixvoid.memoamautas.config.SecurityConstraints.HEADER_STRING;
import static com.nixvoid.memoamautas.config.SecurityConstraints.TOKEN_PREFIX;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
            IOException, ServletException {
        try{
            String requestTokenHeader = parseJwt(request);
            if (requestTokenHeader != null && jwtUtil.validateToken(requestTokenHeader)) {
                String username = jwtUtil.getUsernameFromToken(requestTokenHeader);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userauth = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                userauth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userauth);
            }
        }catch (Exception e){
            logger.warn("Unable to Authorize: " + e);
        }
        filterChain.doFilter(request, response);
    }
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader(HEADER_STRING);
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(TOKEN_PREFIX)) {
            return headerAuth.substring(7);
        }
        return null;
    }

}
