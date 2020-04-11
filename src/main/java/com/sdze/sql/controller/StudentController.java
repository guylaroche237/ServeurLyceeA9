package com.sdze.sql.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
import com.sdze.sql.entite.Student;
import com.sdze.sql.metier.StudentMetier;
import com.sdze.sql.repository.StudenRepository;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentMetier stud;
	
	@Autowired
	private StudenRepository st;
	
	
	  @PostMapping("/save/student") 
	  public void saveStudent(@RequestBody Student student,@RequestParam("file") MultipartFile file) throws IOException {
		  System.out.println("DEBUT DEBUT");
		  Student std = new Student(student.getNom(),student.getLogin(),student.getPassword(),student.getEmail(),student.getDate(),student.getClasse(),compressZLib(file.getBytes()));
		 // System.out.println(student); 
		  stud.addStudent(std);
	  }
	  
	  @PostMapping("/save/eleve/{nom}/{login}/{password}/{email}/{date}/{classes}") 
	  public BodyBuilder saveEleve(@RequestParam("imageFile") MultipartFile file,@PathVariable String nom,@PathVariable String login,@PathVariable String password,@PathVariable String email,@PathVariable String adresse,@DateTimeFormat(iso = ISO.DATE) @PathVariable Date date,@PathVariable String classes) throws IOException {
		  System.out.println("--------------------- DEBUT DE SAUVEGARDE ETUDIANT  --------------------------");
		  Student std = new Student(nom,login,password,email,date,classes,compressZLib(file.getBytes()));
		 // System.out.println(student); 
		  st.save(std);
		  System.out.println("Produit sauvegarder avec success");
	   	return ResponseEntity.status(HttpStatus.OK);
	  }
	 
	
	@GetMapping("/all/students")
	public List<Student> allStudent(){
		System.out.println("Debut");
		//return stud.getAllStudent();
		return st.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentbyId(@PathVariable Long id) {
		return st.getStudentById(id);
	}
	
	@GetMapping("/student/{login}/{password}")
	public Student getStudentLandP(@PathVariable String login,@PathVariable String password) {
		return stud.getStudentByLoginPassword(login, password);
	}
	
	@GetMapping("/students/{classes}")
	public List<Student> getStudentByClasses(@PathVariable String classes){
		return st.getStudentByClasse(classes);
	}
	
	@GetMapping("/student/name/{name}")
	public Student getStudentByNam(@PathVariable String name) {
		return st.getStudentByName(name);
	}
	
	@PostMapping("/save/{nom}/{login}/{password}/{email}/{classe}/{date_exp}")
	public BodyBuilder saveProduit(@PathVariable String nom,@PathVariable String login,@RequestParam("imageFile") MultipartFile file,@PathVariable String password,@PathVariable String email,@PathVariable String classe,@DateTimeFormat(iso = ISO.DATE) @PathVariable Date date_exp) throws IOException {
		Student stu = new Student(nom, login, password, email, date_exp, classe,compressZLib(file.getBytes()));
		//Produit pro = new Produit(nom,code,compressZLib(file.getBytes()),quantite,prixa,prixv,categorie,date_exp);
		//produit.save(pro);
		st.save(stu);
		System.out.println("Produit sauvegarder avec success");
		return ResponseEntity.status(HttpStatus.OK);
		
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

}
