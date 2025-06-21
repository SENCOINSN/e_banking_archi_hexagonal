package com.sid.gl.domain.port.input;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.DataResponse;


public interface CompteServiceUseCase {
    String createCompte(CompteRequestDto requestDto);
    DataResponse getAllComptes(int page,int size);
}
