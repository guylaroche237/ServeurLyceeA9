package com.sdze.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdze.sql.entite.Classes;
import com.sdze.sql.metier.ClassesMetier;
import com.sdze.sql.repository.ClassesRepository;

public class ClasseService implements ClassesMetier{

	@Autowired
	private ClassesRepository cls;
	@Override
	public Classes saveClasses(Classes classes) {
		// TODO Auto-generated method stub
		return cls.save(classes);
	}

	@Override
	public void deleteClasses(Long id) {
		// TODO Auto-generated method stub
		cls.deleteById(id);
	}

	@Override
	public Classes getClasses(Long id) {
		// TODO Auto-generated method stub
		return cls.getOne(id);
	}

	@Override
	public List<Classes> ListClasses() {
		// TODO Auto-generated method stub
		return cls.findAll();
	}

}
