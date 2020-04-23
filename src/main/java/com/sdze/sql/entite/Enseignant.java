package com.sdze.sql.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Enseignant {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String login;
	private String password;
	private Long  tel;
	private String email;
	@Lob
	private byte[] photo;
	@ManyToMany
	private List<Classes> classes;
	private String role;
	private String matiere;
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getMatiere() {
		return matiere;
	}



	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}



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



	public Long getTel() {
		return tel;
	}



	public void setTel(Long tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	public List<Classes> getClasses() {
		return classes;
	}



	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}



	public Enseignant(String nom, Long tel, String email, byte[] photo,String matiere,String login,String password) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.photo = photo;
		this.matiere = matiere;
		this.role = "admin";
		this.login = login;
		this.password = password;
	}



	public Enseignant() {
		super();
	}



	public Enseignant(String nom, Long tel, String email) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.email = email;
	}
	
	
	
	

}
