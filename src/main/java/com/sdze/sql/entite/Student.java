package com.sdze.sql.entite;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String login;
	private String password;
	private String email;
	private Date date;
	private String classe;
	@Lob
	private byte[] profil;
	private String role;
	
	//@OneToMany(mappedBy="student")
	//private Collection<Sms> messages;
	
	
	/*
	 * public Collection<Sms> getMessages() { return messages; } public void
	 * setMessages(Collection<Sms> messages) { this.messages = messages; }
	 */
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte[] getProfil() {
		return profil;
	}
	public void setProfil(byte[] profil) {
		this.profil = profil;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	
	public Student(String nom, String login, String password, String email,Date date,String classe) {
		super();
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.email = email;
		this.date = date;
		this.classe = classe;
		this.role = "eleve";
	}
	
	public Student(String nom, String login, String password, String email, Date date,String classe,byte[] profil) {
		super();
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.email = email;
		this.profil = profil;
		
		this.date = date;
		this.classe = classe;
		this.role = "eleve";
	}
	
	
	public Student(String nom, String login, String password) {
		super();
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.role = "admin";
	}
	
	public Student(String nom, String login, String password,String classes) {
		super();
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.classe = classes;
		this.role = "eleve";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
