package com.sdze.sql.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String keyimg;
	private String name;
	private String type;
	@Lob
	private byte[] file;
	
	
	
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
	public String getKeyimg() {
		return keyimg;
	}
	public void setKeyimg(String keyimg) {
		this.keyimg = keyimg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Photo(String keyimg, String name, String type, byte[] file) {
		super();
		this.keyimg = keyimg;
		this.name = name;
		this.type = type;
		this.file = file;
	}
	
	
	
	
	

}
