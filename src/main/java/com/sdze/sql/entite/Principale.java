package com.sdze.sql.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Principale {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private Enseignant enseignant;
	@ManyToOne
	@JoinColumn(name="id_classes")
	private Classes classes;
	private String login;
	private String password;
	
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Principale(String login,String password,Enseignant enseignant, Classes classes) {
		super();
		this.login = login;
		this.password = password;
		this.enseignant = enseignant;
		this.classes = classes;
	}
	public Principale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
