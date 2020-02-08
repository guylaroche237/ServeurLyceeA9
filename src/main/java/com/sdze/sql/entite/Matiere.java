package com.sdze.sql.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	private String nom_matiere;
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classes classes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_matiere() {
		return nom_matiere;
	}
	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}
	public Matiere(String nom_matiere) {
		super();
		this.nom_matiere = nom_matiere;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
