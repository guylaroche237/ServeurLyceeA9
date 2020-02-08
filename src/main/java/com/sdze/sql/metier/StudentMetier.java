package com.sdze.sql.metier;

import java.util.List;

import com.sdze.sql.entite.Student;

public interface StudentMetier {
	
	public void addStudent(Student std);
	public List<Student> getAllStudent();
	public Student getStudentById(Long id);
	public boolean deleteStudentById(Long id);
	public Student getStudentByLoginPassword(String login,String password);

}
