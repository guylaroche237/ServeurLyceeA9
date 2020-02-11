package com.sdze.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.sql.entite.Enseignant;
import com.sdze.sql.metier.EnseignantMetier;
import com.sdze.sql.repository.EnseignantRepository;

@Service
public class EnseignantService implements EnseignantMetier {

	@Autowired
	private EnseignantRepository ens;
	@Override
	public Enseignant saveEnseignant(Enseignant ense) {
		// TODO Auto-generated method stub
		return ens.save(ense);
	}

	@Override
	public void deleteEnseignant(Long id) {
		// TODO Auto-generated method stub
		ens.deleteById(id);
	}

	@Override
	public List<Enseignant> getEnseignants() {
		// TODO Auto-generated method stub
		return ens.findAll();
	}

	@Override
	public Enseignant getEnseignant(Long id) {
		// TODO Auto-generated method stub
		return ens.getOne(id);
	}

}
