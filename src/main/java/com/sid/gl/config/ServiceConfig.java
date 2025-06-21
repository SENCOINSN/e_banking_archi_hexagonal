package com.sid.gl.config;

import com.sid.gl.domain.port.output.CompteOperationRepositoryPort;
import com.sid.gl.domain.port.output.CompteRepositoryPort;
import com.sid.gl.domain.service.CompteService;
import com.sid.gl.domain.service.OperationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    // Add other service beans as needed
}
