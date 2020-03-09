package com.sdze.sql.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Compose {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private double note;
	private String mention;
	private String sequence;
	@ManyToOne
	@JoinColumn(name="id_matiere")
	private Matiere matiere;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name="id_student")
	private Student student;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public String getMention() {
		
		
		return this.mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public Compose(double note, String sequence,Matiere matiere,Student student) {
		super();
		this.date = new Date();
		this.note = note;
		this.sequence = sequence;
		this.matiere = matiere;
		this.student = student;
		
		if(this.note <=5) {
			this.mention = "Nulle";
		}else if(this.note >5 && this.note<=9) {
			this.mention = "Faible";
		}else if(this.note>=10 && this.note<=12) {
			this.mention = "Passable";
		}else if(this.note>=13 && this.note<17) {
			this.mention = "Bien";
		}else if(this.note>=17 && this.note<=20) {
			this.mention = "TRES bien";
		}
	}
	
	public Compose() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
