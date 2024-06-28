package com.credmarg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.entity.Employee;
import com.credmarg.entity.SentEmails;
import com.credmarg.entity.Vendor;
import com.credmarg.services.EmailServices;
import com.credmarg.services.EmployeeServices;
import com.credmarg.services.VendorServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
     @Autowired
	 private EmployeeServices empService;
     
     @Autowired
     private VendorServices vendorServices;

    @Autowired
    private EmailServices emailService;

    //all employee operation
    //for saving the employee
    @PostMapping("/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
    	try {
         Employee emp= empService.createEmployee(employee);
         return new ResponseEntity<Employee>(emp,HttpStatus.OK);
         }
    	catch(Exception e){
  	      e.printStackTrace();
  	     return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //for seeing all employee
    @GetMapping("/viewEmployees")
    public ResponseEntity<?> viewEmployees() {
      try {
    	List<Employee> emp=empService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
      }
      catch(Exception e){
    	  e.printStackTrace();
    	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
      
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> showEmployeeById(@PathVariable Long id) {
    	try {
    		      Employee emp= empService.getEmployeeById(id);
    		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
    	}
    	catch(Exception e){
      	  e.printStackTrace();
      	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long Id){
    	 
    	try{
    		   String message=empService.deleteEmployeeById(Id);
    		  return new ResponseEntity<String>(message,HttpStatus.OK);
    	}
    	catch(Exception e){
        	  e.printStackTrace();
        	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
          }
      	
    }
    
    //Vendor all operation controller
    
    @PostMapping("/createVendor")
    public ResponseEntity<?> createVendor(@RequestBody Vendor vendor) {
       try {
    	Vendor vend=vendorServices.createVendor(vendor);
        return new ResponseEntity<Vendor>(vend,HttpStatus.OK);
    }
    catch(Exception e){
  	  e.printStackTrace();
  	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/viewVendors")
    public List<Vendor> viewVendors() {
        return vendorServices.getAllVendors();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> showVendorById(@PathVariable List<Long> id) {
    	try {
    		     List<Vendor> ven= vendorServices.getVendorsByIds(id);
    		return new ResponseEntity<List<Vendor>>(ven,HttpStatus.OK);
    	}
    	catch(Exception e){
      	  e.printStackTrace();
      	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVendorById1(@PathVariable Long Id){
    	 
    	try{
    		   String message=vendorServices.deleteVendorById(Id);
    		  return new ResponseEntity<String>(message,HttpStatus.OK);
    	}
    	catch(Exception e){
        	  e.printStackTrace();
        	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
          }
      	
    }     	

    // all email operation
    @PostMapping("/sendEmails")
    public void sendEmails(@RequestBody List<Long> vendorIds) {
        List<Vendor> vendors = vendorServices.getVendorsByIds(vendorIds);
        emailService.sendEmailToVendors(vendors);
    }
    @GetMapping("/viewSentEmails")
    public List<SentEmails> viewSentEmails() {
        return emailService.getAllSentEmails();
    }
}
