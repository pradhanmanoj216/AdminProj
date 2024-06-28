package com.credmarg.services;

import java.util.List;

import com.credmarg.entity.Vendor;

public interface VendorServices {
	
	
	
	public Vendor createVendor(Vendor vendor);
	public List<Vendor> getAllVendors();
	 public List<Vendor> getVendorsByIds(List<Long> vendorIds);
	public String deleteVendorById(Long id);
	
}
