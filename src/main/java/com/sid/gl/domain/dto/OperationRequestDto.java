package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeOperation;
import jakarta.persistence.Enumerated;

public abstract class OperationRequestDto {
    @Enumerated(value = jakarta.persistence.EnumType.STRING)
    protected TypeOperation typeOperation;

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }
}
