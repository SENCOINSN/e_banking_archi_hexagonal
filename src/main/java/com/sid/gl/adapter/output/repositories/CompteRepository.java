package com.sid.gl.adapter.output.repositories;

import com.sid.gl.adapter.output.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
