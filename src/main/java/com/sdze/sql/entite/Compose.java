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
		String resultat = null;
		if(this.note <=5) {
			resultat = "Nulle";
		}else if(this.note >5 && this.note<9) {
			resultat = "Faible";
		}else if(this.note>=10 && this.note<12) {
			resultat = "Passable";
		}else if(this.note>=13 && this.note<17) {
			resultat = "Bien";
		}else if(this.note>=18 && this.note<=20) {
			resultat = "TRES bien";
		}
		return resultat;
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
	public Compose(Date date, double note, String mention) {
		super();
		this.date = date;
		this.note = note;
		this.mention = mention;
	}
	public Compose() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
