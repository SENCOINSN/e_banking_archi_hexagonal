package com.sid.gl.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompteResponseDto {
    private String numeroCompte;
    private String typeCompte;
    private String devise;
    private BigDecimal solde;
    private InfosTitulaireResponseDto infosTitulaire;

}
