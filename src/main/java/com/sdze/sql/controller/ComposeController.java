package com.sdze.sql.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Compose;
import com.sdze.sql.entite.Matiere;
import com.sdze.sql.entite.Student;
import com.sdze.sql.repository.ComposeResitory;
import com.sdze.sql.repository.MatiereRepository;
import com.sdze.sql.repository.StudenRepository;

@RestController
@RequestMapping("/api/compo")
public class ComposeController {
	
	@Autowired
	private ComposeResitory compose;
	@Autowired
	private MatiereRepository mat;
	
	@Autowired
	private StudenRepository stu;
	
	@GetMapping("/seq/{id}/{seq}")
	public List<Compose> findCompoStudentBySequence(@PathVariable long id,@PathVariable String seq){
		return compose.allCompoStudentBySequence(id, seq);
	}
	
	@GetMapping("/matiere/{id}/{mat}")
	public List<Compose> findCompoStudentByMatiere(@PathVariable long id,@PathVariable String mat){
		return compose.allCompoStudentByMatiere(id,mat);
	}
	
	@GetMapping("/all/{id}/{seq}")
	public List<Compose> findCompoStudent(@PathVariable long id){
		return compose.allCompoStudent(id);
	}
	
	@GetMapping("/all")
	public List<Compose> findallCompo(){
		return compose.findAll();
	}
	
	@Transactional
	@PostMapping("/save/{note}/{seq}/{title}/{classes}/{stu}")
	public void saveCompo(@PathVariable double note,@PathVariable String seq,@PathVariable String title,@PathVariable String classes,@PathVariable String stu) {
		Matiere matiere  = this.mat.getMatiereByTitleAndClasse(title, classes);
		Student student = this.stu.getStudentByNameAndClasse(stu, classes);
		Compose compo = new Compose(note, seq, matiere, student);
		compose.save(compo);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteComposition(@PathVariable Long id) {
		compose.deleteById(id);
	}
	
	

}
