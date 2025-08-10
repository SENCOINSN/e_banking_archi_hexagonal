package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeCompte;
import com.sid.gl.exceptions.BadArgumentException;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;


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
    private BigDecimal soldeInitial= BigDecimal.ZERO;


    //validate all fields

    public void  validate() throws BadArgumentException {
        validateRequest();
    }

    private void validateRequest() throws BadArgumentException {
         if(StringUtils.isEmpty(nomTitulaire) || StringUtils.isBlank(nomTitulaire)){
             throw new BadArgumentException("Le nom du titulaire est obligatoire");
         }
        if(StringUtils.isEmpty(prenomTitulaire) || StringUtils.isBlank(prenomTitulaire)){
            throw new BadArgumentException("Le nom du titulaire est obligatoire");
        }
        if(StringUtils.isEmpty(numeroTelephone) || StringUtils.isBlank(numeroTelephone)){
            throw new BadArgumentException("Le numéro de téléphone est obligatoire");
        }

        if(numeroTelephone.length() != 9){
            throw new BadArgumentException("Le numéro de téléphone doit comporter 9 chiffres");
        }
        if(!isValidPhoneNumber(numeroTelephone)){
            throw new BadArgumentException("Le numéro de téléphone doit comporter que des chiffres");
        }
        if(StringUtils.isEmpty(emailTitulaire) || StringUtils.isBlank(emailTitulaire)){
            throw new BadArgumentException("L'email est obligatoire");
        }
        if(!emailTitulaire.contains("@") || !emailTitulaire.contains(".")){
            throw new BadArgumentException("L'email doit contenir un '@' et un '.'");
        }
        if(StringUtils.isEmpty(adresseTitulaire) || StringUtils.isBlank(adresseTitulaire)){
            throw new BadArgumentException("L'adresse est obligatoire");
        }
        if(StringUtils.isEmpty(codePostalTitulaire) || StringUtils.isBlank(codePostalTitulaire)){
            throw new BadArgumentException("Le code postal est obligatoire");
        }
        if(codePostalTitulaire.length() != 6){
            throw new BadArgumentException("Le code postal doit comporter 6 chiffres");
        }
        if(StringUtils.isEmpty(villeTitulaire) || StringUtils.isBlank(villeTitulaire)){
            throw new BadArgumentException("La ville est obligatoire");
        }
        if(StringUtils.isEmpty(paysTitulaire) || StringUtils.isBlank(paysTitulaire)){
            throw new BadArgumentException("Le pays est obligatoire");
        }
    }



    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "^\\d{9}$";
        return Pattern.matches(phoneNumberPattern, phoneNumber.trim());
    }


    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    public String getPrenomTitulaire() {
        return prenomTitulaire;
    }

    public void setPrenomTitulaire(String prenomTitulaire) {
        this.prenomTitulaire = prenomTitulaire;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmailTitulaire() {
        return emailTitulaire;
    }

    public void setEmailTitulaire(String emailTitulaire) {
        this.emailTitulaire = emailTitulaire;
    }

    public String getAdresseTitulaire() {
        return adresseTitulaire;
    }

    public void setAdresseTitulaire(String adresseTitulaire) {
        this.adresseTitulaire = adresseTitulaire;
    }

    public String getCodePostalTitulaire() {
        return codePostalTitulaire;
    }

    public void setCodePostalTitulaire(String codePostalTitulaire) {
        this.codePostalTitulaire = codePostalTitulaire;
    }

    public String getVilleTitulaire() {
        return villeTitulaire;
    }

    public void setVilleTitulaire(String villeTitulaire) {
        this.villeTitulaire = villeTitulaire;
    }

    public String getPaysTitulaire() {
        return paysTitulaire;
    }

    public void setPaysTitulaire(String paysTitulaire) {
        this.paysTitulaire = paysTitulaire;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public BigDecimal getSoldeInitial() {
        return soldeInitial;
    }

    public void setSoldeInitial(BigDecimal soldeInitial) {
        this.soldeInitial = soldeInitial;
    }


}
