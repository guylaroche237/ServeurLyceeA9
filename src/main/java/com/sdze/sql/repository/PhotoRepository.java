package com.sdze.sql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.sql.entite.Photo;


public interface PhotoRepository extends JpaRepository<Photo, Long>{
	
	@Query("SELECT photo FROM Photo photo WHERE photo.keyimg = ?1")
	public Optional<Photo> getPhotoByKey(String key);
	

}
