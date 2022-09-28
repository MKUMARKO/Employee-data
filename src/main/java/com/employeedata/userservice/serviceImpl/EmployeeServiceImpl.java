package com.employeedata.userservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedata.userservice.Exception.UserAlreadyExistsException;
import com.employeedata.userservice.Exception.UserNotFoundException;
import com.employeedata.userservice.models.Employee;
import com.employeedata.userservice.repository.EmployeeRepository;
import com.employeedata.userservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static Logger logUser = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository userRepo;
	
	

	@Override
	public Employee addUser(Employee employee) throws UserAlreadyExistsException {

		if (this.userRepo.existsByUserName(employee.getUserName())) {
			
			logUser.error("User already exist try new one");

			throw new UserAlreadyExistsException("UserName already exist try new one");
		}
		
			
		return userRepo.save(employee);

	}

	@Override
	public List<Employee> viewUser() throws UserNotFoundException {

		List<Employee> employee = userRepo.findAll();
		if (employee == null) {
			throw new UserNotFoundException("User not found");
		} else

			return employee;
	}

	@Override
	public Employee viewUser(String id) throws UserNotFoundException {

		Optional<Employee> employee = userRepo.findById(id);

		Employee u = null;
		if (employee.isPresent()) {

			u = employee.get();
		} else {
			throw new UserNotFoundException("No such User");
		}
		return u;
	}
	
	@Override
	public String deleteUser(String id) throws UserNotFoundException {
		
		String message = null;
		Optional<Employee> employee=userRepo.findById(id);
		if (employee.isPresent()) {
			userRepo.deleteById(id);
			message = "Deleted Successfully";
			logUser.info(message);
		}
		else {
			message = "User Not found";
			logUser.error(message);
		}
		return message;
	}

	@Override
	public Employee updateUser( Employee employee) throws UserNotFoundException {
		Optional<Employee> u = userRepo.findById(employee.getId());

		Employee userRecord = null;
		if (u.isPresent()) {
		  userRecord = u.get();
		   
		
		  
			userRepo.save(employee);
		} else {
			logUser.error("User not found");
		}
		return userRecord;
	}

	

}
