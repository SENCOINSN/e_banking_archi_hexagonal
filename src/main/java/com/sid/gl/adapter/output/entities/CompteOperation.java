package com.sid.gl.adapter.output.entities;

import com.sid.gl.adapter.output.enums.TypeOperation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@Inheritance(strategy = jakarta.persistence.InheritanceType.TABLE_PER_CLASS)
public class CompteOperation extends BaseEntity {
    @Column(unique = true, nullable = false, length = 20)
    private String referenceOperation;
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private TypeOperation typeOperation;
    private String motifOperation;
    @ManyToOne
    @JoinColumn(name = "compte_id", nullable = false)
    private Compte compte;

    //specific fields for each operation type
    private BigDecimal montantTransfert;
    private BigDecimal montantRetrait;
    private BigDecimal montantVersement;

    private String ribBeneficiaire; // RIB for transfer operations

}
