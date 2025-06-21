package com.sid.gl.adapter.output.mappers;

import com.sid.gl.adapter.output.entities.Compte;
import com.sid.gl.adapter.output.entities.InfosTitulaire;
import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.CompteResponseDto;
import com.sid.gl.domain.dto.InfosTitulaireResponseDto;

import java.util.Objects;

public class EBankingMapper {

    public static Compte mapToCompte(CompteRequestDto dto) {
        Compte compte = new Compte();

        if(Objects.nonNull(dto)){
            InfosTitulaire infosTitulaire = new InfosTitulaire();
            infosTitulaire.setNomTitulaire(dto.getNomTitulaire());
            infosTitulaire.setPrenomTitulaire(dto.getPrenomTitulaire());
            infosTitulaire.setNumeroTelephone(dto.getNumeroTelephone());
            infosTitulaire.setEmailTitulaire(dto.getEmailTitulaire());
            infosTitulaire.setAdresseTitulaire(dto.getAdresseTitulaire());
            infosTitulaire.setCodePostalTitulaire(dto.getCodePostalTitulaire());
            infosTitulaire.setVilleTitulaire(dto.getVilleTitulaire());
            infosTitulaire.setPaysTitulaire(dto.getPaysTitulaire());
            compte.setTitulaire(infosTitulaire);
            compte.setTypeCompte(dto.getTypeCompte());
            compte.setSolde(dto.getSoldeInitial());
        }
        return compte;
    }

    public static CompteResponseDto mapToCompteResponseDto(Compte compte) {
        CompteResponseDto dto = new CompteResponseDto();

        if (Objects.nonNull(compte)) {
          dto.setNumeroCompte(compte.getNumeroCompte());
          dto.setTypeCompte(compte.getTypeCompte().getDescription());
          dto.setSolde(compte.getSolde());
          dto.setDevise("CFA"); // Assuming CFA as the default currency
          dto.setInfosTitulaire(mapToInfosTitulaireResponseDto(compte.getTitulaire()));
        }
        return dto;
    }

    public static InfosTitulaireResponseDto mapToInfosTitulaireResponseDto(InfosTitulaire infosTitulaire) {
        InfosTitulaireResponseDto dto = new InfosTitulaireResponseDto();

        if (Objects.nonNull(infosTitulaire)) {
            dto.setNom(infosTitulaire.getNomTitulaire());
            dto.setPrenom(infosTitulaire.getPrenomTitulaire());
            dto.setEmail(infosTitulaire.getEmailTitulaire());
            dto.setTelephone(infosTitulaire.getNumeroTelephone());
            dto.setAdresse(infosTitulaire.getAdresseTitulaire());
        }
        return dto;
    }
}
