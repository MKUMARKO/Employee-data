package com.employeedata.userservice.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Registration form of the user")
@Document(collection = "employee")
public class Employee {

	@Id
	@ApiModelProperty(notes = "This is unique id")
	private String id;
	
	
	@ApiModelProperty(notes = "Enter the Employee name")  
	private String name;
	
	@ApiModelProperty(notes = "Enter the User name")
	private String userName;
	

	@ApiModelProperty(notes = "Enter the contact number")
	private String contactNo;
	
	@ApiModelProperty(notes = "Enter the address")
	private Address address;
	

	@ApiModelProperty(notes = "enter the Job position")
	private String jobPosition;
	
	@ApiModelProperty(notes = "enter the Department")
    private String employeeDept;
	
	@ApiModelProperty(notes = "enter the salary")
	private double salary;
	
	
	@ApiModelProperty(notes = "enter the hire date")
	private LocalDate hireDate;
	
	@ApiModelProperty(notes = "enter the birth date")
	private LocalDate birthDate;
	
	@ApiModelProperty(notes = "enter the bank details")
	private BankDetails bankDetails;



}