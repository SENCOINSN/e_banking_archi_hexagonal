package com.sid.gl.domain.port.input;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.DataResponse;
import com.sid.gl.exceptions.BadArgumentException;


public interface CompteServiceUseCase {
    String createCompte(CompteRequestDto requestDto) throws BadArgumentException;
    DataResponse getAllComptes(int page,int size);
}
