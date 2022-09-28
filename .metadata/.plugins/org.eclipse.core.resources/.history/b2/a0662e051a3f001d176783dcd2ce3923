package com.employeedata.userservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeedata.userservice.Exception.UserAlreadyExistsException;
import com.employeedata.userservice.Exception.UserNotFoundException;
import com.employeedata.userservice.models.Employee;
import com.employeedata.userservice.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")


public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/adduser")
	@ApiOperation(value = "add  the employee")
	public Employee addUser(@RequestBody Employee employee) throws UserAlreadyExistsException {
		return employeeService.addUser(employee);

	}

	@ApiOperation(value = "update   the employee")
	  @PutMapping("/updateuser") public Employee updateUser(@RequestBody Employee employee)
	  throws UserNotFoundException { return employeeService.updateUser(employee);
	  
	  }
	  
	 
	@ApiOperation(value = "find all the employee")
	@GetMapping("/finduser")
	public List<Employee> getUser() throws UserNotFoundException {
		return employeeService.viewUser();
	}
 
	@ApiOperation(value = "find all the employees by id")
	@GetMapping("/finduser/{id}")
	public Employee getUser(@PathVariable String id) throws UserNotFoundException {
		return employeeService.viewUser(id);
	}

	@ApiOperation(value = "delete the employee by id")
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(
			@ApiParam(value = "id of the employee which has to be delete", required = true) @PathVariable String id)
			throws UserNotFoundException {
		return employeeService.deleteUser(id);

	}

	

}