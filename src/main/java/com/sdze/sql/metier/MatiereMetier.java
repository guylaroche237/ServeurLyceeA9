package com.sdze.sql.metier;

import java.util.List;

import com.sdze.sql.entite.Matiere;

public interface MatiereMetier {
	public Matiere addMatier(Matiere matiere);
	public void deleteMatiere(Long id);
	public Matiere getMatiere(Long id);
	public List<Matiere> getMatieres();

}
