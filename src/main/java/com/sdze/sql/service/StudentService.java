package com.sdze.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.sql.entite.Student;
import com.sdze.sql.metier.StudentMetier;
import com.sdze.sql.repository.StudenRepository;

/* GUY LAROCHE CODE 04.02.2020 */

@Service
public class StudentService implements StudentMetier {
	
	@Autowired
	private StudenRepository student;

	@Override
	public void addStudent(Student std) {
		// TODO Auto-generated method stub
		student.save(std);
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return student.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return student.getOne(id);
	}

	@Override
	public boolean deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		student.deleteById(id);
		return true;
	}

	@Override
	public Student getStudentByLoginPassword(String login, String password) {
		// TODO Auto-generated method stub
		return student.getStudentByLoginAndPassWord(login, password);
	}

}
