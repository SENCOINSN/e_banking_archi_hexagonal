package com.sid.gl.domain.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OperationResponseDto {
    private String referenceOperation;
    private String typeOperation;
    private String motifOperation;
    private String ribBeneficiaire;
    private BigDecimal montantTransfert;
    private BigDecimal montantRetrait;
    private BigDecimal montantVersement;
    private LocalDateTime dateOperation;
    private String initiateurOperation;

}
