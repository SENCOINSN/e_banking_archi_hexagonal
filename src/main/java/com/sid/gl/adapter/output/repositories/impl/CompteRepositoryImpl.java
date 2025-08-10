package com.sid.gl.adapter.output.repositories.impl;

import com.sid.gl.adapter.output.entities.Compte;
import com.sid.gl.adapter.output.mappers.EBankingMapper;
import com.sid.gl.adapter.output.repositories.CompteRepository;
import com.sid.gl.adapter.output.security.KeycloakUserService;
import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.CompteResponseDto;
import com.sid.gl.domain.dto.DataResponse;
import com.sid.gl.domain.port.output.CompteRepositoryPort;
import com.sid.gl.exceptions.BadArgumentException;
import com.sid.gl.utils.CompteGenerateur;
import com.sid.gl.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompteRepositoryImpl implements CompteRepositoryPort {

    @Autowired
    @Lazy
    private CompteRepository repository;

    @Autowired
    private KeycloakUserService keycloakUserService;

    @Override
    public String createCompte(CompteRequestDto requestDto) throws BadArgumentException {
        requestDto.validate();
        Compte compte = EBankingMapper.mapToCompte(requestDto);
        compte.setNumeroCompte(CompteGenerateur.generateNumeroCompte(16));
        compte.setRib(CompteGenerateur.generateRIB());
        Compte savedCompte = repository.save(compte);

        String firstName = requestDto.getPrenomTitulaire();
        String lastName = requestDto.getNomTitulaire();
        String email = requestDto.getEmailTitulaire();
        String password = PasswordGenerator.generatePassword();
        //create user in keycloak
        keycloakUserService.createUserCredKeycloak(firstName,lastName,email,password);
        return savedCompte.getNumeroCompte();
    }

    @Override
    public DataResponse getAllComptes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Compte> comptePage = repository.findAll(pageable);
        return buildDataResponse(comptePage);
    }

    private DataResponse buildDataResponse(Page<Compte> comptePage) {
        List<CompteResponseDto> compteResponseDtos = comptePage.getContent().stream()
                .map(EBankingMapper::mapToCompteResponseDto)
                .toList();
        DataResponse dataResponse = new DataResponse();
        dataResponse.setContent(compteResponseDtos);
        dataResponse.setPageNo(comptePage.getNumber());
        dataResponse.setPageSize(comptePage.getSize());
        dataResponse.setTotalElements(comptePage.getTotalElements());
        dataResponse.setTotalPages(comptePage.getTotalPages());
        return dataResponse;
    }
}
