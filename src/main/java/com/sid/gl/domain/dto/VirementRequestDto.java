package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeVirement;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public class VirementRequestDto extends OperationRequestDto{
    private BigDecimal montant;
    private String ribBeneficiaire;
    private String motif;
    @Enumerated(value = jakarta.persistence.EnumType.STRING)
    private TypeVirement typeVirement=TypeVirement.INSTANTANE;
    //private Date dateExecution;

    public VirementRequestDto() {
        super();
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getRibBeneficiaire() {
        return ribBeneficiaire;
    }

    public void setRibBeneficiaire(String ribBeneficiaire) {
        this.ribBeneficiaire = ribBeneficiaire;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public TypeVirement getTypeVirement() {
        return typeVirement;
    }

    public void setTypeVirement(TypeVirement typeVirement) {
        this.typeVirement = typeVirement;
    }
}
