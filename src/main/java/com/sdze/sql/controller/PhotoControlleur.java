package com.sdze.sql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.Photo;
import com.sdze.sql.metier.PhotoMetier;
import com.sdze.sql.repository.PhotoRepository;

@RestController
@RequestMapping("/api/profil")
@CrossOrigin
public class PhotoControlleur {
	
	@Autowired
	private PhotoMetier photo;
	@Autowired
	private PhotoRepository ph;
	
	
	
	
	@PostMapping("/save/{kimg}")
	public void saveProfil(@RequestParam("file") MultipartFile file,@PathVariable String kimg) {
		System.out.println("-------------------  SAVE DE FICHIER ******************** "+kimg);
		photo.savePhoto(file,kimg);
		
		
	}
	
	@GetMapping("/get/{id}")
	public Photo getPhoto(@PathVariable Long id) {
		return photo.getPhotoById(id);
		
	}

}
