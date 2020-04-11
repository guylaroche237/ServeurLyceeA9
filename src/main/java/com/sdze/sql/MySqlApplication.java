package com.sdze.sql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.entite.Compose;
import com.sdze.sql.entite.Matiere;
import com.sdze.sql.entite.MatiereCompo;
import com.sdze.sql.entite.Sms;
import com.sdze.sql.entite.Student;
import com.sdze.sql.entite.Unite;
import com.sdze.sql.repository.ClassesRepository;
import com.sdze.sql.repository.ComposeResitory;
import com.sdze.sql.repository.MatiereCompoRepository;
import com.sdze.sql.repository.MatiereRepository;
import com.sdze.sql.repository.SmsRepository;
import com.sdze.sql.repository.StudenRepository;
import com.sdze.sql.repository.UniteRepository;


@SpringBootApplication
public class MySqlApplication implements CommandLineRunner {
	
	@Autowired
	private StudenRepository student;
	
	@Autowired
	private ClassesRepository classes ;
	@Autowired
	private MatiereRepository matieres;
	
	@Autowired
	private ComposeResitory cmp;
	@Autowired
	private UniteRepository uniterep;
	
	@Autowired
	private SmsRepository sms;
	@Autowired
	private MatiereCompoRepository compo;
	Date jour = new Date();

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
		Unite u = new Unite("Math");Unite u1 = new Unite("Histoire");Unite u2 = new Unite("Physique");Unite u3 = new Unite("Infos");
		Unite u4 = new Unite("Chimie");Unite u5 = new Unite("Francais");Unite u6 = new Unite("Sport");Unite u7 = new Unite("EC");
		Unite u8 = new Unite("SVT");Unite u9 = new Unite("Geographie");Unite u10 = new Unite("Anglais");Unite u11 = new Unite("Allemand");
		Unite u12 = new Unite("Espagnol");Unite u13 = new Unite("Philo");
		uniterep.save(u);uniterep.save(u1);uniterep.save(u2);uniterep.save(u3);uniterep.save(u4);uniterep.save(u5);
		uniterep.save(u6);uniterep.save(u7);uniterep.save(u8);uniterep.save(u9);uniterep.save(u10);uniterep.save(u11);
		uniterep.save(u12);uniterep.save(u13);
		List<Unite> list = new ArrayList<Unite>();
		list.add(u);list.add(u1);list.add(u3);list.add(u5);list.add(u6);list.add(u7);list.add(u9);list.add(u10);
		MatiereCompo mati = new MatiereCompo("6emeA1", list);
		compo.save(mati);
		
		  Student el1 = new Student("talla germaine","leo","admin","Terminale D");
		  Student el2 = new Student("juhiork","paul","reul","3emeA"); Student el3 = new
		  Student("franki","arnold","admin","6emeA1"); Student el4 = new
		  Student("Junior paul","paul","paul","3emeA"); Student el5 = new
		  Student("malla germaine","admin","adminis","Terminale A"); Student el6 = new
		  Student("Kamga frank","paul","julio","3emeA"); Student el7 = new
		  Student("malioloe","admin","armiomin","Premier C"); Student el8 = new
		  Student("franck mba","paulil","paul","3emeA"); Student el9 = new
		  Student("malla madelaine","armandine","admin","3emeB"); Student el10 = new
		  Student("franki","paulin","paul","Terminale C");
		  
		  Student el11 = new Student("Toko junior","admin","admino","6emeA1"); Student
		  el12 = new Student("herman bo","paul","paulol","6emeA2"); Student el13 = new
		  Student("elimbi marcelein","admindd","admin","6emeA1"); Student el14 = new
		  Student("Djoya paul","paul","paugg","5emeA1"); Student el15 = new
		  Student("malla germine","admina","admain","Terminale A"); Student el16 = new
		  Student("Kamdem frank","paurl","julio","5emeA2"); Student el17 = new
		  Student("mari oloye","admin","adminilo","4emeA"); Student el18 = new
		  Student("franck mbara","paul","pauline","4emeB"); Student el19 = new
		  Student("guy eli","admin","morelle","Seconde A"); Student el20 = new
		  Student("mantho sylvie","paulin","paules","Terminale C");
		 
		
		
		
		  Classes h = new Classes(70,"Seconde C"); Classes i = new
		  Classes(65,"Seconde A");Classes k = new Classes(65,"3emeB"); Classes pa = new
		  Classes(65,"Premiere A");Classes pc = new Classes(65,"Premier C");Classes pd
		  = new Classes(65,"Premiere D"); Classes td = new
		  Classes(65,"Terminale D");Classes ta = new Classes(65,"Terminale A");Classes
		  tc = new Classes(65,"Terminale C");
		  
		 
		
		
		
		  classes.save(a);classes.save(b);classes.save(c);
		  classes.save(d);classes.save(e); classes.save(f);classes.save(g);
		  
		  classes.save(k);classes.save(h); classes.save(pa);classes.save(pc);
		  
		  classes.save(pd);classes.save(ta);classes.save(tc); classes.save(td);
		 
		
		student.save(el1);
		student.save(el2);
		student.save(el3);
		student.save(el4);student.save(el5);
		student.save(el6);student.save(el7);
		student.save(el8);student.save(el9);
		student.save(el10);
		student.save(el11);
		student.save(el12);
		student.save(el13);
		student.save(el14);student.save(el15);
		student.save(el16);student.save(el17);
		student.save(el18);student.save(el19);
		student.save(el20);
		
		student.save(el1);
		student.save(el2);
		
		
		Matiere mat = new Matiere("Philosophie", "La Concience",ta);
		
		  matieres.save(new Matiere("Math", "Fonction",a)); matieres.save(new
		  Matiere("Histoire", "1er Geurre M",b)); matieres.save(new Matiere("Histoire",
		  "1er Geurre M",e)); matieres.save(new Matiere("Geographie", "Seisme",d));
		  matieres.save(new Matiere("Francais", "La conjuguason",d)); matieres.save(new
		  Matiere("Philosophie", "La Concience",pa)); matieres.save(new Matiere("Math",
		  "Primitive",pc)); matieres.save(new Matiere("Math", "Fonction",g));
		  matieres.save(new Matiere("Histoire", "1er Geurre M",a)); matieres.save(new
		  Matiere("Histoire", "1er Geurre M",c)); matieres.save(new
		  Matiere("Geographie", "Seisme",e)); matieres.save(mat); matieres.save(new
		  Matiere("Math", "Primitive",tc));
		 
		
		
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("two","One two"));
		//userRepository.save(new User("three","three One"));
		//userRepository.save(new User("four","One four"));
		//userRepository.save(new User("five","five One"));
		  
		Student admin = new Student("admin","admin","admin");
		student.save(admin);
		//student.save(new Student("feukao","borice","m3409U"));
		
		Compose cp = new Compose(13,4, "prem",u, admin);
	 //   cmp.save(cp);
		
		sms.save(new Sms("Bonjour toute la famille",el1));
		sms.save(new Sms("merci comment allez vous",el2));
	//	sms.save(new Sms("mon message",admin,new Date()));
		
		
		
		
	}

}
