package com.sid.gl.domain.port.output;

import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.DataResponse;


public interface CompteRepositoryPort {
    String createCompte(CompteRequestDto requestDto);
    DataResponse getAllComptes(int page,int size);

}
