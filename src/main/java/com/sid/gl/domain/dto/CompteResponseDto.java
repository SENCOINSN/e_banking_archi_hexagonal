package com.sid.gl.domain.dto;
import java.math.BigDecimal;

public class CompteResponseDto {
    private String numeroCompte;
    private String typeCompte;
    private String devise;
    private BigDecimal solde;
    private InfosTitulaireResponseDto infosTitulaire;

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public InfosTitulaireResponseDto getInfosTitulaire() {
        return infosTitulaire;
    }

    public void setInfosTitulaire(InfosTitulaireResponseDto infosTitulaire) {
        this.infosTitulaire = infosTitulaire;
    }
}
