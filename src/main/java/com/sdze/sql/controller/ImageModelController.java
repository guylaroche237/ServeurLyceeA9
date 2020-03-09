package com.sdze.sql.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.ImageModel;
import com.sdze.sql.repository.ImageModelRepository;

@RestController
@RequestMapping("/check")
@CrossOrigin
public class ImageModelController {
	
	@Autowired
	private ImageModelRepository imageModelRepository;
	
	@PostMapping("/upload")
	public ImageModel uploadImage(@RequestParam("myfile") MultipartFile myfile) throws IOException {
		ImageModel img = new ImageModel(myfile.getOriginalFilename(), myfile.getContentType(), myfile.getBytes());
		ImageModel savedImage = imageModelRepository.save(img);
		System.out.println("Image sauvegarder avec success");
		return savedImage;
		
	}

}
