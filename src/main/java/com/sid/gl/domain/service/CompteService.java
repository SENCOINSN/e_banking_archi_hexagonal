package com.sid.gl.domain.service;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.port.input.CompteServiceUseCase;
import com.sid.gl.domain.port.output.CompteRepositoryPort;

import java.util.List;

public class CompteService implements CompteServiceUseCase {
   private final CompteRepositoryPort compteRepository;

    public CompteService(CompteRepositoryPort compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public String createCompte(CompteRequestDto requestDto) {
        return "";
    }

    @Override
    public List<CompteRequestDto> getAllComptes() {
        return List.of();
    }
}
