package com.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.project.dto.EmployeeDTO;
import com.project.entity.Employee;
import com.project.repository.EmployeeDAOImpl;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	public List<EmployeeDTO> getEmployee() {
		List<Employee> empList = employeeDAOImpl.getEmployee();
		List<EmployeeDTO> resultList = empList.stream().map(e -> e.getDTO()).collect(Collectors.toList());
		return resultList;
	}
	
	public EmployeeDTO getEmployee(String id) {
		EmployeeDTO employeeDTO = employeeDAOImpl.getEmployee(id).getDTO();
		return employeeDTO;
	}

	public String addEmployee(EmployeeDTO employeeDTO) {
		employeeDAOImpl.addEmployee(employeeDTO.prepareEntity());
		return "Employee Added Successfully";
	}

	public String updateEmployee(EmployeeDTO employeeDTO) {
		employeeDAOImpl.updateEmployee(employeeDTO.prepareEntity());
		return "Employee Updated Successfully";
	}

	public EmployeeDTO removeEmployee(String id) {
		EmployeeDTO employeeDTO = employeeDAOImpl.removeEmployee(id).getDTO();
		return employeeDTO;
	}
}
