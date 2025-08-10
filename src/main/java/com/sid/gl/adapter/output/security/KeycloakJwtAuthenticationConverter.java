package com.sid.gl.adapter.output.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class KeycloakJwtAuthenticationConverter  implements Converter<Jwt, AbstractAuthenticationToken> {
    private static final String CLIENT_ID = "api-paiement-app";

    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        return new JwtAuthenticationToken(
                source,
                Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source).stream(),
                                extractResourceRoles(source).stream())
                        .collect(toSet()),
                getClientName(source)
        );
    }

    private String getClientName(Jwt jwt) {
        return jwt.getClaim("preferred_username");
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        var resourceAccess = new HashMap<>(jwt.getClaim("resource_access"));

        var eternal = (Map<String, List<String>>) resourceAccess.get(CLIENT_ID);

        var roles = eternal.get("roles");

      Set<SimpleGrantedAuthority> rolesSet = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(toSet());

        return rolesSet;
    }
}
