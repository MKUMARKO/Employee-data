package com.cropdeal.userservice.serviceImpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employeedata.userservice.Exception.UserNotFoundException;
import com.employeedata.userservice.models.Employee;
import com.employeedata.userservice.repository.EmployeeRepository;
import com.employeedata.userservice.serviceImpl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeServiceImplTest.class)
class EmployeeServiceImplTest {

	@Mock
	Employee employee;

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Test
	void addUserTest() {
		employeeServiceImpl.addUser(employee);
		verify(employeeRepository, times(1)).save(any());
	}

	@Test
	void updateUserTest() {
		employee = new Employee();
		Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
		employeeServiceImpl.updateUser(employee);
		verify(employeeRepository, times(1)).save(any());
	}

	@Test
	void viewAllUser() {
		Mockito.when(employeeRepository.findAll()).thenReturn(Stream.of(employee).collect(Collectors.toList()));
		assertEquals(1, employeeServiceImpl.viewUser().size());
	}

	@Test
	void viewAllUserException() {
		Mockito.when(employeeRepository.findAll()).thenReturn(null);
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			employeeServiceImpl.viewUser();
		});
		String expectedMessage = "User not found";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void viewUserTest() {
		Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
		employeeServiceImpl.viewUser(any());
		verify(employeeRepository, times(1)).findById(any());
	}

	@Test
	void viewUserExceptionTest() {
		Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.empty());
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			employeeServiceImpl.viewUser(any());
		});
		String expectedMessage = "No such User";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void deleteOrderTest() {
		Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));
		String string = employeeServiceImpl.deleteUser(any());
		verify(employeeRepository, times(1)).deleteById(any());
		assertEquals("Deleted Successfully", string);

	}

	@Test
	void deleteUserNotFoundTest() {
		Mockito.when(employeeRepository.findById(any())).thenReturn(Optional.empty());
		String string = employeeServiceImpl.deleteUser(any());
		assertEquals("User Not found", string);
	}

}
