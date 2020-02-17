package com.sdze.sql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.sql.entite.Sms;
import com.sdze.sql.metier.SmsMetier;
import com.sdze.sql.repository.SmsRepository;

@Service
public class SmsService implements SmsMetier {

	@Autowired
	private SmsRepository sms;
	@Override
	public void addSms(Sms mess) {
		// TODO Auto-generated method stub
		sms.save(mess);
		
	}

	@Override
	public List<Sms> allSms() {
		// TODO Auto-generated method stub
		return sms.findAll();
	}

}
