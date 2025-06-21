package com.sid.gl.domain.service;

import com.sid.gl.domain.dto.DepotRequestDto;
import com.sid.gl.domain.dto.RetraitRequestDto;
import com.sid.gl.domain.dto.VirementRequestDto;
import com.sid.gl.domain.port.input.OperationUseCase;
import com.sid.gl.domain.port.output.CompteOperationRepositoryPort;
import org.springframework.context.annotation.Lazy;

public class OperationService implements OperationUseCase {

    private final CompteOperationRepositoryPort compteOperationRepositoryPort;

    public OperationService(@Lazy CompteOperationRepositoryPort compteOperationRepositoryPort) {
        this.compteOperationRepositoryPort = compteOperationRepositoryPort;
    }

    @Override
    public String depot(String numeroCompte, DepotRequestDto depotRequestDto) {
        return compteOperationRepositoryPort.depot(numeroCompte, depotRequestDto);
    }

    @Override
    public String retrait(String numeroCompte, RetraitRequestDto retraitRequestDto) {
        return compteOperationRepositoryPort.retrait(numeroCompte, retraitRequestDto);
    }

    @Override
    public String virement(String numeroCompte, VirementRequestDto virementRequestDto) {
        return compteOperationRepositoryPort.virement(numeroCompte, virementRequestDto);
    }
}
