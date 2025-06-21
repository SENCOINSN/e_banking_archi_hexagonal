package com.sid.gl.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RetraitRequestDto extends OperationRequestDto {
    private BigDecimal montantRetrait;

    public RetraitRequestDto() {
        super();
    }
}
