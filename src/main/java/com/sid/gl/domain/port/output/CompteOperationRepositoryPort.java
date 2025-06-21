package com.sid.gl.domain.port.output;

import com.sid.gl.domain.dto.DepotRequestDto;
import com.sid.gl.domain.dto.RetraitRequestDto;
import com.sid.gl.domain.dto.VirementRequestDto;

public interface CompteOperationRepositoryPort {
     String depot(String numeroCompte,DepotRequestDto depotRequestDto);
     String retrait(String numeroCompte,RetraitRequestDto retraitRequestDto);
     String virement(String numeroCompte,VirementRequestDto virementRequestDto);
}
