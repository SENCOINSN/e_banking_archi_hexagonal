package com.sid.gl.utils;

import com.sid.gl.domain.dto.AuthUserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class AuthenticationUtils {

    public static AuthUserDto getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof JwtAuthenticationToken){
           JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
           Jwt jwt = jwtAuthenticationToken.getToken();
           String username = jwt.getClaimAsString("preferred_username");
           String email = jwt.getClaimAsString("email");
           return new AuthUserDto(username,email);
        }else{
            return null;
        }
    }
}
