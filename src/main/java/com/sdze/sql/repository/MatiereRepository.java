package com.sdze.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.sql.entite.Matiere;


public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	
	@Query("SELECT matiere FROM Matiere matiere WHERE matiere.classes.nom = ?1")
	public List<Matiere> getMatiereByNameClasse(String name);

}
