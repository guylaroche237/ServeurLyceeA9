package com.sdze.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.sql.entite.Student;
import com.sdze.sql.repository.StudenRepository;


@SpringBootApplication
public class MySqlApplication implements CommandLineRunner {
	
	@Autowired
	private StudenRepository student;

	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("three","three One"));
		//userRepository.save(new User("four","One four"));
		//userRepository.save(new User("five","five One"));
		student.save(new Student("feuko","laroche","laroche22"));
		//student.save(new Student("feukao","borice","m3409U"));
		
		
	}

}
