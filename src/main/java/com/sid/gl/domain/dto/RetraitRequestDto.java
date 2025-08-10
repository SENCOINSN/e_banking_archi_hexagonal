package com.sid.gl.domain.dto;

import java.math.BigDecimal;

public class RetraitRequestDto extends OperationRequestDto {
    private BigDecimal montantRetrait;

    public RetraitRequestDto() {
        super();
    }

    public BigDecimal getMontantRetrait() {
        return montantRetrait;
    }

    public void setMontantRetrait(BigDecimal montantRetrait) {
        this.montantRetrait = montantRetrait;
    }
}
