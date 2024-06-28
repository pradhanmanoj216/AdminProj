package com.credmarg.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.credmarg.entity.SentEmails;

public interface SentEmailRepository extends JpaRepository<SentEmails, Long> {
	
}

