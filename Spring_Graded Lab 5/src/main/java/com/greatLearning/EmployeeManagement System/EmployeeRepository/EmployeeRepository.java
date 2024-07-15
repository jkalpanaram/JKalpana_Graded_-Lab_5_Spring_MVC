package com.greatLearning.EmployeeManagementSystem.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.EmployeeManagementSystem.EmployeeModel.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {

}