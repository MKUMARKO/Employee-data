package com.cropdeal.userservice.resourse.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.employeedata.userservice.resource.EmployeeController;
import com.employeedata.userservice.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmplyeeControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeService employeeService;
	
	

    
}
