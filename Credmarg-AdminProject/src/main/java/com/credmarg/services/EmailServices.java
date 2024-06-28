package com.credmarg.services;

import java.util.List;

import com.credmarg.entity.SentEmails;
import com.credmarg.entity.Vendor;

public interface EmailServices {

	
	 public void sendEmailToVendors(List<Vendor> vendors);
	 public List<SentEmails> getAllSentEmails();
}
