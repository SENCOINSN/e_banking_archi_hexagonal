package com.sid.gl.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepotRequestDto extends OperationRequestDto {
 private BigDecimal montantDepot;

 public DepotRequestDto() {
     super();
 }
}
