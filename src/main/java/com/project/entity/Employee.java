package com.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.project.dto.AddressDTO;
import com.project.dto.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Employee {

	@Id
	private String empId;
	private String empName;
	private String salary;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public EmployeeDTO getDTO() {
		AddressDTO addressDTO = new AddressDTO(this.address.getAddressId(),this.address.getCity(),this.address.getPincode());
		EmployeeDTO employeeDTO = new EmployeeDTO(this.empId,this.empName,this.salary,addressDTO);
		return employeeDTO;
	}
}
