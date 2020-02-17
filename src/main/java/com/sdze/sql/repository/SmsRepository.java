package com.sdze.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdze.sql.entite.Sms;

public interface SmsRepository extends JpaRepository<Sms,Long>{

}
