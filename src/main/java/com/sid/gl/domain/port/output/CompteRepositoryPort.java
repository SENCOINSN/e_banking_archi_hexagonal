package com.sid.gl.domain.port.output;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.CompteResponseDto;

import java.util.List;

public interface CompteRepositoryPort {
    String createCompte(CompteRequestDto requestDto);
    List<CompteResponseDto> getAllComptes();

}
