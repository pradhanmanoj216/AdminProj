package com.credmarg.services;

import java.util.List;

import com.credmarg.entity.Employee;

public interface EmployeeServices {
	
	 public Employee createEmployee(Employee employee);
	 public List<Employee> getAllEmployees();
	 public Employee getEmployeeById(Long id);
     public String deleteEmployeeById(Long id);

}
