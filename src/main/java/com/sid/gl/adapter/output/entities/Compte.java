package com.sid.gl.adapter.output.entities;

import com.sid.gl.adapter.output.enums.TypeCompte;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_COMPTE")
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Compte extends BaseEntity {
    private String numeroCompte;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
    @Embedded
    private InfosTitulaire titulaire;
    private String rib;
    private String iban;
    private BigDecimal solde;

}
