package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.sql.entite.Enseignant;


public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	
	@Query("SELECT enseignant FROM Enseignant enseignant WHERE enseignant.nom = ?1")
	public Enseignant  getEnseignantByName(String nom);

}
