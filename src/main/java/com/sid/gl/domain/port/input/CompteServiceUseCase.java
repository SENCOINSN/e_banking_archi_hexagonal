package com.sid.gl.domain.port.input;

import com.sid.gl.domain.dto.CompteRequestDto;

import java.util.List;

public interface CompteServiceUseCase {
    String createCompte(CompteRequestDto requestDto);
    List<CompteRequestDto> getAllComptes();
}
