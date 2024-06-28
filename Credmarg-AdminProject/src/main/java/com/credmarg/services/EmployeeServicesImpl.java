package com.credmarg.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.entity.Employee;
import com.credmarg.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	
	    @Autowired
	    private EmployeeRepository employeeRepository;
        
	    @Override
	    public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }
        @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
        
        
        public Employee getEmployeeById(Long id) {
          return employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("employee id not found"));
        	
        }
        
        @Override
        public String deleteEmployeeById(Long id) {
        	 Optional<Employee> opt=employeeRepository.findById(id);
              if(opt.isPresent()) {
            	  employeeRepository.deleteById(id);
                return id+" id employee deleted ";              
              }
              else {
            	  return id+" id employee not found for deletion";
              }
              }
	    
	    
	}

	
