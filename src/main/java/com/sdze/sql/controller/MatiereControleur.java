package com.sdze.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Matiere;
import com.sdze.sql.metier.MatiereMetier;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.MatiereRepository;

@RestController
@RequestMapping("/api/matiere")
public class MatiereControleur {
	
	@Autowired
	private MatiereMetier matiere;
	@Autowired
	private ClassesRepository classerep;
	
	@Autowired
	private MatiereRepository mrep;
	
	@GetMapping("/all")
	public List<Matiere> getMatiere() {
		return matiere.getMatieres();
	}
	
	@GetMapping("/{name}")
	public List<Matiere> getMatiereByClasse(@PathVariable String name){
		return matiere.getMatiereByclasse(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMatiere(@PathVariable long id) {
		matiere.deleteMatiere(id);
	}
	
	@PostMapping("/save/{titre}/{nom}/{clas}")
	public void saveMatiere(@PathVariable String titre,@PathVariable String nom,@PathVariable String clas) {
		
		Classes cls = classerep.findClassesByName(clas);
		
		Matiere m = new Matiere(titre,nom,cls);
		matiere.addMatier(m);
		
	}
	
	@GetMapping("/{title}/{cls}")
	public Matiere findMatiereByClasseAndTitle(@PathVariable String title,@PathVariable String cls) {
		return mrep.getMatiereByTitleAndClasse(title, cls);
	}
	
	

}
