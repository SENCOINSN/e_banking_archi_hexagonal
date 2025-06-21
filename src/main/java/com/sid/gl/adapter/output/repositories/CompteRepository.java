package com.sid.gl.adapter.output.repositories;

import com.sid.gl.adapter.output.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    @Query("select c from Compte c where c.rib = ?1")
    Optional<Compte> findByRib(String rib);

    @Query("select c from Compte c where c.numeroCompte = ?1")
    Optional<Compte> findByNumeroCompte(String numeroCompte);


}
