package com.sdze.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Student;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.StudenRepository;


@SpringBootApplication
public class MySqlApplication implements CommandLineRunner {
	
	@Autowired
	private StudenRepository student;
	
	@Autowired
	private ClassesRepository classes ;

	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		classes.save(new Classes(65,"6emeA1"));classes.save(new Classes(65,"6emeA2"));classes.save(new Classes(65,"6emeA3"));
		classes.save(new Classes(65,"5emeA1"));classes.save(new Classes(65,"5emeA2"));
		classes.save(new Classes(65,"4emeB"));classes.save(new Classes(65,"4emeA"));classes.save(new Classes(65,"3emeB"));
		classes.save(new Classes(75,"3emeA"));classes.save(new Classes(53,"Seconde A"));classes.save(new Classes(70,"Seconde C"));
		classes.save(new Classes(45,"Premiere A"));classes.save(new Classes(28,"Premiere C"));classes.save(new Classes(60,"Premiere D"));
		classes.save(new Classes(20,"Terminale A"));classes.save(new Classes(65,"Terminale D"));classes.save(new Classes(65,"Terminale C"));
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("three","three One"));
		//userRepository.save(new User("four","One four"));
		//userRepository.save(new User("five","five One"));
		student.save(new Student("feuko","laroche","laroche22"));
		//student.save(new Student("feukao","borice","m3409U"));
		
		
	}

}
