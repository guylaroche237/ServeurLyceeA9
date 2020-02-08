package com.sdze.sql.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Enseignant {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String tel;
	private String email;
	private String photo;
	@ManyToMany
	private List<Classes> classes;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public List<Classes> getClasses() {
		return classes;
	}



	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}



	public Enseignant() {
		super();
	}



	public Enseignant(String nom, String tel, String email) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.email = email;
	}
	
	
	
	

}
