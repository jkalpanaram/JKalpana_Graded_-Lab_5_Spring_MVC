package com.greatLearning.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.EmployeeManagementSystem.EmployeeModel.EmployeeDetails;
import com.greatLearning.EmployeeManagementSystem.EmployeeRepository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	// getAllEmployees() will returns a list of all EmployeeDetails entities in the
	// database
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// getting Employees Details by using getEmployeeById
	public EmployeeDetails getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	// saveEmployee() method used to save Employee Details
	public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
		return employeeRepository.save(employeeDetails);
	}

	public void deleteEmployeebyId(Long id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails, Long id) {
		EmployeeDetails employeeDetail = getEmployeeById(id);
		employeeDetail.setFirstName(employeeDetails.getFirstName());
		employeeDetail.setLastName(employeeDetails.getLastName());
		employeeDetail.setEmail(employeeDetails.getEmail());
		// Save the updated employee
		return saveEmployee(employeeDetails);
	}

}