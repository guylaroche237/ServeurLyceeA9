package com.sdze.sql.metier;

import java.util.List;

import com.sdze.sql.entite.Classes;

public interface ClassesMetier {
	public Classes saveClasses(Classes classes);
	public void deleteClasses(Long id);
	public Classes getClasses(Long id);
	public List<Classes> ListClasses();

}
