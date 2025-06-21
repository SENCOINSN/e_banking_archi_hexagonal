package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeOperation;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Data
public abstract class OperationRequestDto {
    @Enumerated(value = jakarta.persistence.EnumType.STRING)
    protected TypeOperation typeOperation;
}
