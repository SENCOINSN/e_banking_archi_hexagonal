package com.sid.gl.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public String getReferenceOperation() {
        return referenceOperation;
    }

    public void setReferenceOperation(String referenceOperation) {
        this.referenceOperation = referenceOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getMotifOperation() {
        return motifOperation;
    }

    public void setMotifOperation(String motifOperation) {
        this.motifOperation = motifOperation;
    }

    public String getRibBeneficiaire() {
        return ribBeneficiaire;
    }

    public void setRibBeneficiaire(String ribBeneficiaire) {
        this.ribBeneficiaire = ribBeneficiaire;
    }

    public BigDecimal getMontantTransfert() {
        return montantTransfert;
    }

    public void setMontantTransfert(BigDecimal montantTransfert) {
        this.montantTransfert = montantTransfert;
    }

    public BigDecimal getMontantRetrait() {
        return montantRetrait;
    }

    public void setMontantRetrait(BigDecimal montantRetrait) {
        this.montantRetrait = montantRetrait;
    }

    public BigDecimal getMontantVersement() {
        return montantVersement;
    }

    public void setMontantVersement(BigDecimal montantVersement) {
        this.montantVersement = montantVersement;
    }

    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDateTime dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getInitiateurOperation() {
        return initiateurOperation;
    }

    public void setInitiateurOperation(String initiateurOperation) {
        this.initiateurOperation = initiateurOperation;
    }
}
