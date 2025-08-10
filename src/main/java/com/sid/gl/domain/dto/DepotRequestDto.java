package com.sid.gl.domain.dto;


import java.math.BigDecimal;


public class DepotRequestDto extends OperationRequestDto {
 private BigDecimal montantDepot;

 public DepotRequestDto() {
     super();
 }

    public BigDecimal getMontantDepot() {
        return montantDepot;
    }

    public void setMontantDepot(BigDecimal montantDepot) {
        this.montantDepot = montantDepot;
    }
}
