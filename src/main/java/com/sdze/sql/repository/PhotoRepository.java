package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdze.sql.entite.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long>{
	

}
