package com.sdze.sql.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Enseignant;

import com.sdze.sql.metier.EnseignantMetier;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.EnseignantRepository;

@RestController
@RequestMapping("/api/enseignant")
@CrossOrigin
public class EnseignantController {
	
	@Autowired
	private EnseignantMetier ens;
	
	@Autowired
	private EnseignantRepository enseignant;
	@Autowired
	private ClassesRepository clas;
	
	
	
	@PostMapping("/save/{nom}/{tel}/{email}/{matiere}/{login}/{password}")
	public BodyBuilder saveEnseignant(@PathVariable("nom") String nom,@PathVariable("tel") Long tel, @PathVariable("email") String email,@RequestParam("imageFile") MultipartFile file,@PathVariable("matiere") String matiere,@PathVariable("login") String login,@PathVariable("password") String password) throws IOException {
		
		Enseignant ense= new Enseignant(nom,tel,email,compressZLib(file.getBytes()),matiere,login,password);
		enseignant.save(ense);
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/get/{id}")
	public Enseignant getEnseignant(@PathVariable Long id) {
	
		final Optional<Enseignant> ensegnant_profil = enseignant.findById(id);
		Enseignant img = new Enseignant (ensegnant_profil.get().getNom(),ensegnant_profil.get().getTel(),ensegnant_profil.get().getEmail(),decompressZLib(ensegnant_profil.get().getPhoto()),ensegnant_profil.get().getMatiere(),ensegnant_profil.get().getLogin(),ensegnant_profil.get().getPassword());
		img.setId(ensegnant_profil.get().getId());
		return img;
		//return photo.getPhotoById(id);
		
	}
	
	@GetMapping("/all")
	public List<Enseignant> getAllsEnseignants(){
		List<Enseignant> alls = new ArrayList<Enseignant>();
		List<Enseignant> listes = enseignant.findAll();
		for(Enseignant e:listes) {
			Enseignant ens = new Enseignant(e.getNom(),e.getTel(),e.getEmail(),decompressZLib(e.getPhoto()),e.getMatiere(),e.getLogin(),e.getPassword());
			ens.setId(e.getId());
			alls.add(ens);
		}
		return alls;
	}
	
	@GetMapping("/sign/{login}/{password}/{sale}")
	public boolean connection(@PathVariable String login, @PathVariable String password,@PathVariable String sale) {
		Classes cls = clas.findClassesByName(sale);
		Enseignant ens = enseignant.getEnseignantByLoginAndPass(login, password);
		boolean rep = false;
		
		if(ens != null) {
			for(Enseignant e :cls.getEnseignants()) {
				if(e.equals(ens)) {
					rep = true;
					
				}
			}
		}
		
		
		
		return rep;
	}
	
	@GetMapping("/sign/{login}/{password}")
	public Enseignant connection(@PathVariable String login, @PathVariable String password) {
		Enseignant ens = enseignant.getEnseignantByLoginAndPass(login, password);
		return ens;
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
