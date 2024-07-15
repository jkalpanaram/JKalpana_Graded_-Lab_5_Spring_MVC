package com.greatLearning.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.EmployeeManagementSystem.EmployeeModel.EmployeeDetails;
import com.greatLearning.EmployeeManagementSystem.service.EmployeeService;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

//	@Autowired
//	public EmployeeController(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}

	@GetMapping("/employees")
	public String listEmployee(Model model) {
		List<EmployeeDetails> employeesDetail = employeeService.getAllEmployees();
		model.addAttribute("employees", employeesDetail);
		// This maps to a Thymeleaf template for listing employees
		return "employees";
	}

	@GetMapping("/employees/new")
	public String showFormForAdd(Model model) {
		EmployeeDetails employeesDetails = new EmployeeDetails();
		model.addAttribute("employee", employeesDetails);
		// This maps to a Thymeleaf template for adding employees
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") EmployeeDetails employeeDetails) {
		employeeService.saveEmployee(employeeDetails);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		EmployeeDetails employeeDetails = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employeeDetails);
		// This maps to a Thymeleaf template for updating employees
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") EmployeeDetails employeeDetails,
			Model model) {
		employeeService.updateEmployee(employeeDetails, id);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeebyId(id);
		return "redirect:/employees";
	}
}