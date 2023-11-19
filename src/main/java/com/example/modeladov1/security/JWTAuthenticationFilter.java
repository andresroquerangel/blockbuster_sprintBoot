package com.example.modeladov1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authManager;
    private final UserDetailsService userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
    public JWTAuthenticationFilter(AuthenticationManager authManager, UserDetailsService userDetailsService) {
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
        super.setAuthenticationManager(authManager); // Asegúrate de establecer el AuthenticationManager correctamente
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();
        try{
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch(IOException e){
        }

        UsernamePasswordAuthenticationToken userNamePAT = new UsernamePasswordAuthenticationToken(authCredentials.getEmail(),authCredentials.getPassword(), Collections.emptyList());
        return getAuthenticationManager().authenticate(userNamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        String token = TokenUtil.createToken(userDetails.getNombre(),userDetails.getUsername(),userDetails.getAuthorities());
        logger.info(token);
        response.addHeader("Authorization","Bearer "+token);
        response.getWriter().flush();

        super.successfulAuthentication(request,response,chain,authResult);
    }
}
