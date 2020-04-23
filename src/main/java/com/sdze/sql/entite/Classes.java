package com.sdze.sql.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classes {
	@Id
	@GeneratedValue
	private Long id;
	private int nbre;
	private String nom;
	@ManyToMany
	private List<Enseignant> enseignants;
	@OneToMany
	private List<Student> eleves;
	
	@OneToMany(mappedBy="classes",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Matiere> matieres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public List<Student> getEleves() {
		return eleves;
	}

	public void setEleves(List<Student> eleves) {
		this.eleves = eleves;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(int nbre, String nom) {
		super();
		this.nbre = nbre;
		this.nom = nom;
	}

	public Classes(int nbre, String nom, List<Enseignant> enseignants) {
		super();
		this.nbre = nbre;
		this.nom = nom;
		this.enseignants = enseignants;
	}
	
	
	
	
	
	

}
