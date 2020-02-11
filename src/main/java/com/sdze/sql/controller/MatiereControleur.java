package com.sdze.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Matiere;
import com.sdze.sql.metier.MatiereMetier;

@RestController
@RequestMapping("/api/matiere")
public class MatiereControleur {
	
	@Autowired
	private MatiereMetier matiere;
	
	@GetMapping("/all")
	public List<Matiere> getMatiere() {
		return matiere.getMatieres();
	}
	
	@GetMapping("/{name}")
	public List<Matiere> getMatiereByClasse(@PathVariable String name){
		return matiere.getMatiereByclasse(name);
	}
	
	

}
