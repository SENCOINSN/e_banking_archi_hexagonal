package com.sid.gl.domain.dto;

import com.sid.gl.adapter.output.enums.TypeCompte;
import com.sid.gl.exceptions.BadArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CompteRequestDtoTest {

    private CompteRequestDto compteRequestDto;

    @BeforeEach
    void setUp() {
        // Initialize a valid CompteRequestDto before each test
        compteRequestDto = new CompteRequestDto();
        compteRequestDto.setNomTitulaire("Dupont");
        compteRequestDto.setPrenomTitulaire("Jean");
        compteRequestDto.setNumeroTelephone("123456789");
        compteRequestDto.setEmailTitulaire("jean.dupont@example.com");
        compteRequestDto.setAdresseTitulaire("123 Rue de Paris");
        compteRequestDto.setCodePostalTitulaire("123456");
        compteRequestDto.setVilleTitulaire("Paris");
        compteRequestDto.setPaysTitulaire("France");
        compteRequestDto.setTypeCompte(TypeCompte.COURANT);
        compteRequestDto.setSoldeInitial(BigDecimal.valueOf(1000));
    }

    @Test
    @DisplayName("Test validation with valid account creation data")
    void testValidateWithValidData() {
        // When a valid CompteRequestDto is validated
        // Then no exception should be thrown
        assertDoesNotThrow(() -> compteRequestDto.validate());
    }

    @Test
    @DisplayName("Test validation with missing nom titulaire")
    void testValidateWithMissingNomTitulaire() {
        // Given a CompteRequestDto with missing nom titulaire
        compteRequestDto.setNomTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le nom du titulaire est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing prenom titulaire")
    void testValidateWithMissingPrenomTitulaire() {
        // Given a CompteRequestDto with missing prenom titulaire
        compteRequestDto.setPrenomTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le nom du titulaire est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing numero telephone")
    void testValidateWithMissingNumeroTelephone() {
        // Given a CompteRequestDto with missing numero telephone
        compteRequestDto.setNumeroTelephone("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le numéro de téléphone est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with invalid numero telephone length")
    void testValidateWithInvalidNumeroTelephoneLength() {
        // Given a CompteRequestDto with invalid numero telephone length
        compteRequestDto.setNumeroTelephone("12345");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le numéro de téléphone doit comporter 9 chiffres", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with non-numeric numero telephone")
    void testValidateWithNonNumericNumeroTelephone() {
        // Given a CompteRequestDto with non-numeric numero telephone
        compteRequestDto.setNumeroTelephone("12345678a");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le numéro de téléphone doit comporter que des chiffres", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing email titulaire")
    void testValidateWithMissingEmailTitulaire() {
        // Given a CompteRequestDto with missing email titulaire
        compteRequestDto.setEmailTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("L'email est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with invalid email format")
    void testValidateWithInvalidEmailFormat() {
        // Given a CompteRequestDto with invalid email format
        compteRequestDto.setEmailTitulaire("invalid-email");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("L'email doit contenir un '@' et un '.'", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing adresse titulaire")
    void testValidateWithMissingAdresseTitulaire() {
        // Given a CompteRequestDto with missing adresse titulaire
        compteRequestDto.setAdresseTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("L'adresse est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing code postal titulaire")
    void testValidateWithMissingCodePostalTitulaire() {
        // Given a CompteRequestDto with missing code postal titulaire
        compteRequestDto.setCodePostalTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le code postal est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with invalid code postal length")
    void testValidateWithInvalidCodePostalLength() {
        // Given a CompteRequestDto with invalid code postal length
        compteRequestDto.setCodePostalTitulaire("12345");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le code postal doit comporter 6 chiffres", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing ville titulaire")
    void testValidateWithMissingVilleTitulaire() {
        // Given a CompteRequestDto with missing ville titulaire
        compteRequestDto.setVilleTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("La ville est obligatoire", exception.getMessage());
    }

    @Test
    @DisplayName("Test validation with missing pays titulaire")
    void testValidateWithMissingPaysTitulaire() {
        // Given a CompteRequestDto with missing pays titulaire
        compteRequestDto.setPaysTitulaire("");
        
        // When the CompteRequestDto is validated
        // Then a BadArgumentException should be thrown with the appropriate message
        BadArgumentException exception = assertThrows(
            BadArgumentException.class,
            () -> compteRequestDto.validate()
        );
        
        assertEquals("Le pays est obligatoire", exception.getMessage());
    }
}