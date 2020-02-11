package com.sdze.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Matiere;
import com.sdze.sql.entite.Student;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.MatiereRepository;
import com.sdze.sql.repository.StudenRepository;


@SpringBootApplication
public class MySqlApplication implements CommandLineRunner {
	
	@Autowired
	private StudenRepository student;
	
	@Autowired
	private ClassesRepository classes ;
	@Autowired
	private MatiereRepository matieres;

	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Classes a = new Classes(65,"6emeA1");Classes b = new Classes(65,"6emeA2");
		Classes c= new Classes(65,"5emeA1");Classes d= new Classes(65,"5emeA2");
		Classes e = new Classes(65,"4emeB");Classes f = new Classes(65,"4emeA");
		Classes g = new Classes(75,"3emeA");
		
		Classes h = new Classes(70,"Seconde C");
		Classes i = new Classes(65,"Seconde A");Classes k = new Classes(65,"3emeB");
		Classes pa = new Classes(65,"Premiere A");Classes pc = new Classes(65,"Premier C");Classes pd = new Classes(65,"Premiere D");
		Classes td = new Classes(65,"Terminale D");Classes ta = new Classes(65,"Terminale A");Classes tc = new Classes(65,"Terminale C");

				
		classes.save(a);classes.save(b);classes.save(c);
		classes.save(d);classes.save(e);
		classes.save(f);classes.save(g);
		
		classes.save(k);classes.save(h);
		classes.save(pa);classes.save(pc);
		
		classes.save(pd);classes.save(ta);classes.save(tc);
		classes.save(td);
		
		
		matieres.save(new Matiere("Math", "Fonction",a));
		matieres.save(new Matiere("Histoire", "1er Geurre M",b));matieres.save(new Matiere("Histoire", "1er Geurre M",e));
		matieres.save(new Matiere("Geographi", "Seisme",d));matieres.save(new Matiere("Francais", "La conjuguason",d));
		matieres.save(new Matiere("Philosopie", "La Concience",pa));matieres.save(new Matiere("Math", "Primitive",pc));
		matieres.save(new Matiere("Math", "Fonction",g));
		matieres.save(new Matiere("Histoire", "1er Geurre M",a));matieres.save(new Matiere("Histoire", "1er Geurre M",c));
		matieres.save(new Matiere("Geographi", "Seisme",e));matieres.save(new Matiere("Francais", "La conjuguason",d));
		matieres.save(new Matiere("Philosopie", "La Concience",ta));matieres.save(new Matiere("Math", "Primitive",tc));
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("three","three One"));
		//userRepository.save(new User("four","One four"));
		//userRepository.save(new User("five","five One"));
		student.save(new Student("feuko","laroche","laroche22"));
		//student.save(new Student("feukao","borice","m3409U"));
		
		
	}

}
