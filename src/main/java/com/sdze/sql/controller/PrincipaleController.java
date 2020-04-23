package com.sdze.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Enseignant;
import com.sdze.sql.entite.Principale;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.EnseignantRepository;
import com.sdze.sql.repository.PrincipaleRepository;

@RestController
@RequestMapping("/api/principale")
@CrossOrigin(origins = "http://localhost:4200")
public class PrincipaleController {
	
	@Autowired
	private PrincipaleRepository principale;
	@Autowired
	private EnseignantRepository enseignant;
	@Autowired
	private ClassesRepository sale;
	
	@PostMapping("/save/{ens}/{classes}")
	public Principale savePrincipale(@PathVariable String ens,@PathVariable String classes) {
		Enseignant teacher = enseignant.getEnseignantByName(ens);
		Classes clas = sale.findClassesByName(classes);
		Principale prin = new Principale(teacher, clas);
		return principale.save(prin);
		
	}
	
	@GetMapping("/all")
	public List<Principale> allPrincipale(){
		return principale.findAll();
	}

}
