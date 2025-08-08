package com.sid.gl.adapter.output.security;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KeycloakUserService {

    private final KeyCloakProperties properties;

    public KeycloakUserService(KeyCloakProperties properties) {
        this.properties = properties;
    }

    public void createUserCredKeycloak(String name,String email,String password){
        log.info("process to create user in keycloak with username: {}, email: {}, password: {}", name, email, password);
        var kc = KeycloakBuilder.builder()
                .serverUrl(properties.getServerUrl())
                .realm(properties.getRealm())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .build();
                /*.grantType(OAuth2Constants.PASSWORD)
                .username(adminUsername).password(adminPassword)
                .clientId(clientId)
                .build();*/

        var kcUser = new UserRepresentation();
        kcUser.setUsername(email);
        kcUser.setEmail(email);
        kcUser.setEnabled(true);

        var cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(password);
        kcUser.setCredentials(List.of(cred));

        var resp = kc.realm(properties.getRealm()).users().create(kcUser);
        if(resp.getStatus() != 201) {
            log.error("Error creating user in Keycloak: {}", resp.getStatusInfo());
            throw new RuntimeException("Failed to create user in Keycloak");
        }
    }

}
