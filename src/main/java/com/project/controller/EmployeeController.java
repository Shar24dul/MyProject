package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.AddressDTO;
import com.project.dto.EmployeeDTO;
import com.project.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
		
	@PostMapping({"/","/show"})
	public String show(@ModelAttribute("EmployeeDTO") EmployeeDTO employeeDTO, @ModelAttribute("AddressDTO") AddressDTO addressDTO, Model model) {
		employeeDTO.setAddressDTO(addressDTO);
		model.addAttribute("EmployeeDTO", employeeDTO);
		model.addAttribute("salary",employeeDTO.getSalary());
		System.out.println(employeeDTO);
		return "show";
	}
	
	@GetMapping("/getAll")
	public List<EmployeeDTO> getEmployee() {
		List<EmployeeDTO> empList = employeeServiceImpl.getEmployee();
		return empList;
	}
	
	@GetMapping("/get/{id}")
	public EmployeeDTO getEmployee(@PathVariable String id) {
		EmployeeDTO employeeDTO = employeeServiceImpl.getEmployee(id);
		return employeeDTO;
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		String result = employeeServiceImpl.addEmployee(employeeDTO);
		return result;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeServiceImpl.updateEmployee(employeeDTO);
	}
	
	@DeleteMapping("removeEmployee/{id}")
	public EmployeeDTO removeEmployee(@PathVariable String id) {
		return employeeServiceImpl.removeEmployee(id);
	}
}
