package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeVirement;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;


@Data
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

}
