package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdze.sql.entite.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
