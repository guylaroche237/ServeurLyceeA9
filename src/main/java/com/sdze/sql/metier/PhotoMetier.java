package com.sdze.sql.metier;

import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.Photo;

public interface PhotoMetier {
	public void savePhoto(MultipartFile f,String k);
	public Photo getPhotoById(Long id);

}
