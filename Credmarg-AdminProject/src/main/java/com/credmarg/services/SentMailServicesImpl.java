package com.credmarg.services;


	
	

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.credmarg.entity.SentEmails;
import com.credmarg.entity.Vendor;
import com.credmarg.repository.SentEmailRepository;


	@Service
	public class SentMailServicesImpl implements EmailServices {

	    @Autowired
	    private JavaMailSender mailSender;

	    @Autowired
	    private SentEmailRepository sentEmailRepository;
	    
        @Override
	    public void sendEmailToVendors(List<Vendor> vendors) {
	        for (Vendor vendor : vendors) {
	            String body = "Sending payments to vendor " + vendor.getName() + " at UPI " + vendor.getUpi();
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(vendor.getEmail());
	            message.setSubject("Payment Notification");
	            message.setText(body);

	            mailSender.send(message);

	            SentEmails sentEmail = new SentEmails();
	            sentEmail.setVendorId(vendor.getId());
	            sentEmail.setEmail(vendor.getEmail());
	            sentEmail.setBody(body);
	            sentEmail.setTimestamp(LocalDateTime.now());

	            sentEmailRepository.save(sentEmail);
	        }
	    }
        
        @Override
	    public List<SentEmails> getAllSentEmails() {
	        return sentEmailRepository.findAll();
	    }
	}

