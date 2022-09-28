package com.employeedata.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employeedata.userservice.models.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

	boolean existsByUserName(String userName);

	Employee findByUserName(String username);


} 