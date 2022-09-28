package com.employeedata.userservice.service;

import java.util.List;

import com.employeedata.userservice.Exception.UserAlreadyExistsException;
import com.employeedata.userservice.Exception.UserNotFoundException;
import com.employeedata.userservice.models.Employee;


public interface EmployeeService {
	
	
	public Employee addUser(Employee employee) throws UserAlreadyExistsException;
	
	public List<Employee> viewUser() throws UserNotFoundException;
	
	public Employee viewUser(String id) throws UserNotFoundException;
	
	public String deleteUser(String id) throws UserNotFoundException;
	
	public Employee updateUser(Employee employee)  throws UserNotFoundException;
	
}
