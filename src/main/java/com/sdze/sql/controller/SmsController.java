package com.sdze.sql.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sql.entite.Sms;
import com.sdze.sql.entite.Student;
import com.sdze.sql.metier.SmsMetier;
import com.sdze.sql.metier.StudentMetier;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
	
	@Autowired
	private SmsMetier smsmetier;
	@Autowired
	private StudentMetier student;
	
	@PostMapping("/save/{message}/{id}")
	public void addSms(@PathVariable("message") String message,@PathVariable("id") Long id) {
		Student stu = student.getStudentById(id);
		Sms sms = new Sms(message,stu);
		smsmetier.addSms(sms);
		
	}
	@GetMapping("/all")
	public List<Sms> allSms() {
		return smsmetier.allSms();
	}

}
