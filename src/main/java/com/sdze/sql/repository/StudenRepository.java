package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sdze.sql.entite.Student;

public interface StudenRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT student FROM Student student WHERE student.login = ?1 and student.password = ?2")
	public Student getStudentByLoginAndPassWord(String login,String password);
	
	@Query("SELECT student FROM Student student WHERE student.id = ?1")
	public Student getStudentById(Long login);

}
