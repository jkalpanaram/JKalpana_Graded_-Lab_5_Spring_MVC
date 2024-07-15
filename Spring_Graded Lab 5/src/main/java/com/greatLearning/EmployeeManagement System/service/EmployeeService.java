package com.greatLearning.EmployeeManagementSystem.service;

import java.util.List;

import com.greatLearning.EmployeeManagementSystem.EmployeeModel.EmployeeDetails;

public interface EmployeeService {

	List<EmployeeDetails> getAllEmployees();

	EmployeeDetails saveEmployee(EmployeeDetails employeeDetails);

	EmployeeDetails getEmployeeById(Long id);

	EmployeeDetails updateEmployee(EmployeeDetails updatedEmployee, Long id);

	void deleteEmployeebyId(Long id);

}