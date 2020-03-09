package com.sdze.sql.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.ImageModel;
import com.sdze.sql.entite.Photo;
import com.sdze.sql.metier.PhotoMetier;
import com.sdze.sql.repository.ImageModelRepository;
import com.sdze.sql.repository.PhotoRepository;

@RestController
@RequestMapping("/api/profil")
@CrossOrigin
public class PhotoControlleur {
	
	@Autowired
	private PhotoMetier photo;
	@Autowired
	private PhotoRepository rep_photo;
	
	@Autowired
	private ImageModelRepository image;
	
	
	
	
	
	@PostMapping("/save/{kimg}")
	public BodyBuilder saveProfil(@RequestParam("file") MultipartFile file,@PathVariable String kimg) throws IOException {
		
		Photo img = new Photo(kimg,file.getOriginalFilename(),file.getContentType(),compressZLib(file.getBytes()));
		rep_photo.save(img);
	  //	photo.savePhoto(file,kimg);
		
    	//String upload ="src/main/resources/static/images";
    	//File fichier = new File(upload+"/joel.jpg");
    	//String route = fichier.getAbsolutePath();
	  //  String chemin = request.getServletContext().getRealPath(upload);
	
		//Files.copy(file.getInputStream(), Paths.get(upload, file.getOriginalFilename()));	
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public Photo getPhoto(@PathVariable Long id) {
		final Optional<Photo> retrievedImage = rep_photo.findById(id);
		Photo img = new Photo(retrievedImage.get().getKey(),retrievedImage.get().getName(),retrievedImage.get().getType(),decompressZLib(retrievedImage.get().getFile()));
		return img;
		//return photo.getPhotoById(id);
		
	}
	
	@GetMapping("/get/cle/{key}")
	public Photo getPhotoByKey(@PathVariable String key) {
		final Optional<Photo> retrievedImage = rep_photo.getPhotoByKey(key);
		Photo img = new Photo(retrievedImage.get().getKey(),retrievedImage.get().getName(),retrievedImage.get().getType(),decompressZLib(retrievedImage.get().getFile()));
		return img;
		//return photo.getPhotoById(id);
		
	}
	
	public static byte[] compressZLib(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	public static byte[] decompressZLib(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
