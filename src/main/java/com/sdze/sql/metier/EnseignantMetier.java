package com.sdze.sql.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdze.sql.entite.Enseignant;


public interface EnseignantMetier {
	public Enseignant saveEnseignant(Enseignant ens);
	public void deleteEnseignant(Long id);
	public List<Enseignant> getEnseignants();
	public Enseignant getEnseignant(Long id);

}
