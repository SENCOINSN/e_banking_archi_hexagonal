package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeCompte;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompteRequestDto {
    @NotNull(message = "Le nom du titulaire est obligatoire")
    @NotBlank(message = "Le nom du titulaire est obligatoire")
    private String nomTitulaire;

    @NotNull(message = "Le prénom du titulaire est obligatoire")
    @NotBlank(message = "Le prénom du titulaire est obligatoire")
    private String prenomTitulaire;
    @Size(min = 9,max = 9, message = "Le numéro de téléphone doit comporter 9 chiffres")
    @NotNull(message = "Le numéro de téléphone est obligatoire")
    @Pattern(regexp = "\\d+", message = "Le numéro de téléphone doit comporter 9 chiffres")
    private String numeroTelephone;
    @NotNull(message = "L'email est obligatoire")
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String emailTitulaire;
    @NotNull(message = "L'adresse est obligatoire")
    @NotBlank(message = "L'adresse est obligatoire")
    @Size(max = 50, message = "L'adresse ne doit pas dépasser 50 caractères")
    private String adresseTitulaire;
    @NotNull(message = "Le code postal est obligatoire")
    @NotBlank(message = "Le code postal est obligatoire")
    @Size(min = 6, max = 6, message = "Le code postal doit comporter 5 chiffres")
    private String codePostalTitulaire;
    @NotNull(message = "La ville est obligatoire")
    @NotBlank(message = "La ville est obligatoire")
    private String villeTitulaire;
    @NotNull(message = "Le pays est obligatoire")
    @NotBlank(message = "Le pays est obligatoire")
    private String paysTitulaire;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
    private BigDecimal soldeInitial= BigDecimal.ZERO;
}
