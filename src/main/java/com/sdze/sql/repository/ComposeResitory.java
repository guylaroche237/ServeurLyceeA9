package com.sdze.sql.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sdze.sql.entite.Compose;
import com.sdze.sql.entite.Student;

public interface ComposeResitory extends JpaRepository<Compose, Long> {
	
	@Query("SELECT compos FROM Compose compos WHERE compos.student.id = ?1 AND compos.sequence = ?2 ")
	public List<Compose> allCompoStudentBySequence(Long id_student,String sequence);
	
	@Transactional
	@Modifying
	@Query("SELECT compos FROM Compose compos WHERE compos.student.id = ?1 AND compos.matiere.title = ?2 ")
	public List<Compose> allCompoStudentByMatiere(Long id_student,String matiere);
	
	@Transactional
	@Modifying
	@Query("SELECT compos FROM Compose compos WHERE compos.student.id = ?1")
	public List<Compose> allCompoStudent(Long id_student);

}
