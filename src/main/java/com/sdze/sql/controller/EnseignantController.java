package com.sdze.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Enseignant;
import com.sdze.sql.metier.EnseignantMetier;

@RestController
@RequestMapping("/api/enseignant")
@CrossOrigin
public class EnseignantController {
	
	@Autowired
	private EnseignantMetier ens;
	
	@GetMapping("/all")
	public List<Enseignant> getAllEnseignants(){
		
		return ens.getEnseignants();
	}

}
