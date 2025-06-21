package com.sid.gl.adapter.output.repositories.impl;

import com.sid.gl.adapter.output.entities.Compte;
import com.sid.gl.adapter.output.entities.CompteOperation;
import com.sid.gl.adapter.output.mappers.EBankingMapper;
import com.sid.gl.adapter.output.repositories.CompteOperationRepository;
import com.sid.gl.adapter.output.repositories.CompteRepository;
import com.sid.gl.domain.dto.DepotRequestDto;
import com.sid.gl.domain.dto.RetraitRequestDto;
import com.sid.gl.domain.dto.VirementRequestDto;
import com.sid.gl.domain.port.output.CompteOperationRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Repository
public class CompteOperationRepositoryImpl implements CompteOperationRepositoryPort {

    @Autowired
    @Lazy
    private CompteOperationRepository repository;

    @Autowired
    @Lazy
    private CompteRepository compteRepository;



    @Transactional
    @Override
    public String depot(String numeroCompte, DepotRequestDto depotRequestDto) {
        log.info("processus depot pour le compte : {}", numeroCompte);
        // check le montant à deposer
        validateMontant(depotRequestDto.getMontantDepot());
        //check le numero de compte
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found with numero : " + numeroCompte));
        CompteOperation operation = EBankingMapper.mapDepotToCompteOperation(depotRequestDto);
        operation.setMontantVersement(depotRequestDto.getMontantDepot());
        operation.setCompte(compte);
        operation.setDateOperation(LocalDateTime.now());
        BigDecimal nouveauSolde = addMontant(depotRequestDto.getMontantDepot(), compte.getSolde());
        compte.setSolde(nouveauSolde);
        // sauvegarder le compte avec le nouveau solde
        compteRepository.save(compte);
        CompteOperation savedOperation = repository.save(operation);
        log.info("Operation Depot saved with id : {}", savedOperation.getReferenceOperation());

        // todo send notification to client otp for validation

        return savedOperation.getReferenceOperation();
    }

    @Transactional
    @Override
    public String retrait(String numeroCompte,RetraitRequestDto retraitRequestDto) {
        log.info("processus retrait pour le compte : {}", numeroCompte);
        // check le montant à retirer
        validateMontant(retraitRequestDto.getMontantRetrait());
        // vérifier si le solde est suffisant
        //check le numero de compte
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found with numero : " + numeroCompte));

        verifierSoldeSuffisant(retraitRequestDto.getMontantRetrait(), compte.getSolde());

        CompteOperation operation = EBankingMapper.mapRetraitToCompteOperation(retraitRequestDto);
        operation.setCompte(compte);
        operation.setDateOperation(LocalDateTime.now());
        operation.setMontantRetrait(retraitRequestDto.getMontantRetrait());

        BigDecimal nouveauSolde = subtractMontant(retraitRequestDto.getMontantRetrait(), compte.getSolde());
        compte.setSolde(nouveauSolde);
        // sauvegarder le compte avec le nouveau solde
        compteRepository.save(compte);
        CompteOperation savedOperation = repository.save(operation);
        log.info("Operation retrait saved with id : {}", savedOperation.getReferenceOperation());

        // todo send notification to client otp for validation

        return savedOperation.getReferenceOperation();
    }

    @Transactional
    @Override
    public String virement(String numeroCompte,VirementRequestDto virementRequestDto) {
        log.info("processus virement pour le compte : {}", numeroCompte);
        // check le montant à virer
        validateMontant(virementRequestDto.getMontant());
        validateRibClient(virementRequestDto.getRibBeneficiaire());

        Compte compteEmetteur = compteRepository.findByNumeroCompte(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found with numero : " + numeroCompte));

        verifierSoldeSuffisant(virementRequestDto.getMontant(), compteEmetteur.getSolde());

        Compte compteBeneficiaire = compteRepository.findByRib(virementRequestDto.getRibBeneficiaire())
                .orElseThrow(() -> new RuntimeException("Compte not found with rib : " + virementRequestDto.getRibBeneficiaire()));

        CompteOperation operationEmetteur = EBankingMapper.mapVirementToCompteOperation(virementRequestDto);
        operationEmetteur.setMontantTransfert(virementRequestDto.getMontant());
        BigDecimal nouveauSoldeEmetteur = subtractMontant(virementRequestDto.getMontant(), compteEmetteur.getSolde());
        compteEmetteur.setSolde(nouveauSoldeEmetteur);

        BigDecimal nouveauSoldeBeneficiaire = addMontant(virementRequestDto.getMontant(), compteBeneficiaire.getSolde());
        compteBeneficiaire.setSolde(nouveauSoldeBeneficiaire);

        operationEmetteur.setCompte(compteEmetteur);
        operationEmetteur.setDateOperation(LocalDateTime.now());
        // save compte emetteur et compte beneficiaire
        compteRepository.save(compteEmetteur);
        compteRepository.save(compteBeneficiaire);
        CompteOperation savedOperation = repository.save(operationEmetteur);
        log.info("Operation virement saved with id : {}", savedOperation.getReferenceOperation());

        // todo send notification to client otp for validation

        return savedOperation.getReferenceOperation();
    }


    //todo setup validate otp code for each operation



    private void validateRibClient(String ribBeneficiaire) {
        compteRepository.findByRib(ribBeneficiaire)
                .orElseThrow(()->new RuntimeException("Compte not found with rib : "+ribBeneficiaire));
    }


    private void validateMontant(BigDecimal montant){
        if(montant == null || montant.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Le montant doit être supérieur à zéro.");
        }
    }

    private BigDecimal addMontant(BigDecimal montant, BigDecimal solde) {
        return solde.add(montant);
    }

    private BigDecimal subtractMontant(BigDecimal montant, BigDecimal solde) {
        return solde.subtract(montant);
    }

    private void verifierSoldeSuffisant(BigDecimal montant, BigDecimal solde) {
        if (montant.compareTo(solde) > 0) {
            throw new RuntimeException("Le solde est insuffisant pour effectuer cette opération.");
        }
    }

}
