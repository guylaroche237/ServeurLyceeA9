package com.sdze.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sdze.sql.entite.Student;

@Transactional
public interface StudenRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT student FROM Student student WHERE student.login = ?1 and student.password = ?2")
	public Student getStudentByLoginAndPassWord(String login,String password);
	
	@Query("SELECT student FROM Student student WHERE student.id = ?1")
	public Student getStudentById(Long login);
	
	@Query("SELECT student FROM Student student WHERE student.classe = ?1")
	public List<Student> getStudentByClasse(String classes);
	
	@Query("SELECT student FROM Student student WHERE student.nom = ?1")
	public Student getStudentByName(String name);
	
	@Query("SELECT student FROM Student student WHERE student.nom = ?1 AND student.classe = ?2")
	public Student getStudentByNameAndClasse(String name,String classes);

}
