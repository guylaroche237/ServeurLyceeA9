package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.sql.entite.Classes;

public interface ClassesRepository extends JpaRepository<Classes, Long> {
	
	@Query("SELECT cls FROM Classes cls WHERE cls.nom = ?1")
	public Classes findClassesByName(String name);

}
