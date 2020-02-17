package com.sdze.sql.metier;

import java.util.List;

import com.sdze.sql.entite.Sms;

public interface SmsMetier {
	
	public void addSms(Sms sms);
	public List<Sms> allSms();

}
