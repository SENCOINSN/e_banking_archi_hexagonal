package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeCompte;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompteRequestDto {
    private String nomTitulaire;
    private String prenomTitulaire;
    private String numeroTelephone;
    private String emailTitulaire;
    private String adresseTitulaire;
    private String codePostalTitulaire;
    private String villeTitulaire;
    private String paysTitulaire;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
    private BigDecimal soldeInitial;
}
