package com.sid.gl.domain.service;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.DataResponse;
import com.sid.gl.domain.port.input.CompteServiceUseCase;
import com.sid.gl.domain.port.output.CompteRepositoryPort;
import org.springframework.context.annotation.Lazy;


public class CompteService implements CompteServiceUseCase {

   private final CompteRepositoryPort compteRepositoryPort;

    public CompteService(@Lazy CompteRepositoryPort compteRepositoryPort) {
        this.compteRepositoryPort = compteRepositoryPort;
    }

    @Override
    public String createCompte(CompteRequestDto requestDto) {
        return compteRepositoryPort.createCompte(requestDto);
    }

    @Override
    public DataResponse getAllComptes(int page,int size) {
        return compteRepositoryPort.getAllComptes(page,size);
    }
}
