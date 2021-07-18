package com.project.dto;

import java.io.Serializable;

import com.project.entity.Address;
import com.project.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class EmployeeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String empId;
	private String empName;
	private String salary;
	private AddressDTO addressDTO;
	
	public Employee prepareEntity() {
		Address address = new Address(this.addressDTO.getAddressId(),this.addressDTO.getCity(),this.addressDTO.getPincode());
		Employee employee = new Employee(this.empId,this.empName,this.salary,address);
		return employee;
	}
}
