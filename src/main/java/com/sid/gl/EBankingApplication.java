package com.sid.gl;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(
		name = "keycloak",
		type = SecuritySchemeType.OAUTH2,
		bearerFormat = "JWT",
		scheme = "bearer",
		in = SecuritySchemeIn.HEADER,
		flows = @OAuthFlows(
				password = @OAuthFlow(
						authorizationUrl = "http://212.227.78.64:8080/realms/sencoin-realm/protocol/openid-connect/auth",
						tokenUrl = "http://212.227.78.64:8080/realms/sencoin-realm/protocol/openid-connect/token"
				)
		)
)
public class EBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

}
