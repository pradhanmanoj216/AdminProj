package com.credmarg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.entity.Vendor;
import com.credmarg.repository.VendorRepository;

@Service
public class VendorServicesImpl implements VendorServices {



	    @Autowired
	    private VendorRepository vendorRepository;
	    
	    
        @Override
	    public Vendor createVendor(Vendor vendor) {
	        return vendorRepository.save(vendor);
	    }
       @Override
	    public List<Vendor> getAllVendors() {
	        return vendorRepository.findAll();
	    }
         
	    @Override 
	    public List<Vendor> getVendorsByIds(List<Long> vendorIds) {
	    	
	    	
	       	return  vendorRepository.findAllById(vendorIds);
	    	     
	          
	    }
	    
	    @Override
        public String deleteVendorById(Long id) {
        	 Optional<Vendor> opt=vendorRepository.findById(id);
              if(opt.isPresent()) {
            	  vendorRepository.deleteById(id);
                return id+" id bendov deleted ";              
              }
              else {
            	  return id+" id vendore not found for deletion";
              }
              }
		
	    
	}


