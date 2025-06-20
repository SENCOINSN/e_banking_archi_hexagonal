package com.sid.gl.adapter.output.repositories.impl;

import com.sid.gl.adapter.output.repositories.CompteRepository;
import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.CompteResponseDto;
import com.sid.gl.domain.port.output.CompteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompteRepositoryImpl implements CompteRepositoryPort {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public String createCompte(CompteRequestDto requestDto) {
        return "";
    }

    @Override
    public List<CompteResponseDto> getAllComptes() {
        return List.of();
    }
}
