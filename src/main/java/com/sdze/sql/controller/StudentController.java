package com.sdze.sql.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Student;
import com.sdze.sql.metier.StudentMetier;
import com.sdze.sql.repository.StudenRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class StudentController {
	
	@Autowired
	private StudentMetier stud;
	
	@Autowired
	private StudenRepository st;
	
	
	  @PostMapping("/save/student") 
	  public void saveStudent(@RequestBody Student student) {
		  System.out.println(student); stud.addStudent(student);
	  
	  
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

}
