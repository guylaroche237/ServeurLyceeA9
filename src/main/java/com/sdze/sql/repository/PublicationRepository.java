package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdze.sql.entite.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
