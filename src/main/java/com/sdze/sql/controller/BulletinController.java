package com.sdze.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Bulletin;
import com.sdze.sql.entite.Compose;
import com.sdze.sql.repository.BulletinRepository;

@RestController
@RequestMapping("/api/bulletin")
@CrossOrigin(origins = "http://localhost:4200")
public class BulletinController {
	
	@Autowired
	private BulletinRepository bulletin;
	
	@PostMapping("/save")
	public Bulletin saveBulletin(@RequestBody List<Compose> compos) {
		System.out.println("-----------------  DEBUT  -----------------------");
		Bulletin bull = new Bulletin(compos);
		return bulletin.save(bull);
		
	}
	
	@GetMapping("/all")
	public List<Bulletin> getAllBulletin(){
		return bulletin.findAll();
	}
	
	@GetMapping("/get/{seq}/{cls}")
	public List<Bulletin> getBulletinBySeqAndClasse(@PathVariable String seq,@PathVariable String cls){
		return bulletin.getBulletinBySequenceAndClasses(seq, cls);
		
	}
	
	@GetMapping("/id/{id}")
	public Bulletin getBulletinById(@PathVariable long id) {
		return bulletin.getBulletinById(id);
	}

}
