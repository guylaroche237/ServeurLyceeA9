package com.sdze.sql.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	@Lob
	private byte[] file;
	
	private String keyimg;
	
	public String getKey() {
		return keyimg;
	}
	public void setKey(String keyimg) {
		this.keyimg = keyimg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Photo(String name, byte[] file,String keyimg) {
		super();
		this.name = name;
		this.file = file;
		this.keyimg = keyimg;
	}
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(String name, byte[] file) {
		super();
		this.name = name;
		this.file = file;
	}
	
	
	
	
	

}
