package com.sid.gl.adapter.output.mappers;

import com.sid.gl.adapter.output.entities.Compte;
import com.sid.gl.adapter.output.entities.CompteOperation;
import com.sid.gl.adapter.output.entities.InfosTitulaire;
import com.sid.gl.adapter.output.enums.OperationStatus;
import com.sid.gl.adapter.output.enums.TypeOperation;
import com.sid.gl.domain.dto.*;

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

    public static CompteOperation mapDepotToCompteOperation(DepotRequestDto dto) {
        CompteOperation operation = new CompteOperation();

        if (Objects.nonNull(dto)) {
            operation.setTypeOperation(TypeOperation.DEPOT);
            operation.setStatus(OperationStatus.PENDING);
        }
        return operation;
    }

    public static CompteOperation mapRetraitToCompteOperation(RetraitRequestDto dto) {
        CompteOperation operation = new CompteOperation();

        if (Objects.nonNull(dto)) {
            operation.setTypeOperation(TypeOperation.RETRAIT);
            operation.setStatus(OperationStatus.PENDING);
        }
        return operation;
    }

    public static CompteOperation mapVirementToCompteOperation(VirementRequestDto dto) {
        CompteOperation operation = new CompteOperation();

        if (Objects.nonNull(dto)) {
            operation.setTypeOperation(TypeOperation.VIREMENT);
            operation.setStatus(OperationStatus.PENDING);
            operation.setRibBeneficiaire(dto.getRibBeneficiaire());
            operation.setMotifOperation(dto.getMotif());
            //todo différer le process pour le virement différé

        }
        return operation;
    }


}
