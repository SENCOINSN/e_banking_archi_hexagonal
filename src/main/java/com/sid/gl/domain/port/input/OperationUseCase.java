package com.sid.gl.domain.port.input;

import com.sid.gl.domain.dto.DepotRequestDto;
import com.sid.gl.domain.dto.RetraitRequestDto;
import com.sid.gl.domain.dto.VirementRequestDto;

public interface OperationUseCase {
    String depot(String numeroCompte, DepotRequestDto depotRequestDto);
    String retrait(String numeroCompte, RetraitRequestDto retraitRequestDto);
    String virement(String numeroCompte, VirementRequestDto virementRequestDto);
}
