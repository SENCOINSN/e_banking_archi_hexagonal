package com.sid.gl.adapter.output.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class InfosTitulaire {
    private String nomTitulaire;
    private String prenomTitulaire;
    private String numeroTelephone;
    private String emailTitulaire;
    private String adresseTitulaire;
    private String codePostalTitulaire;
    private String villeTitulaire;
    private String paysTitulaire;

}
