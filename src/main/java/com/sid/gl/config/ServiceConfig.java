package com.sid.gl.config;

import com.sid.gl.domain.port.output.CompteOperationRepositoryPort;
import com.sid.gl.domain.port.output.CompteRepositoryPort;
import com.sid.gl.domain.service.CompteService;
import com.sid.gl.domain.service.OperationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class ServiceConfig {

    @Bean
   public CompteService compteService(CompteRepositoryPort repository) {
        return new CompteService(repository);
    }

    @Bean
    public OperationService operationService(CompteOperationRepositoryPort compteOperationRepositoryPort) {
        return new OperationService(compteOperationRepositoryPort);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.ORIGIN,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT,
                HttpHeaders.AUTHORIZATION
        ));
        config.setAllowedMethods(Arrays.asList(
                "GET",
                "POST",
                "DELETE",
                "PUT",
                "PATCH"
        ));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }

    // Add other service beans as needed
}
