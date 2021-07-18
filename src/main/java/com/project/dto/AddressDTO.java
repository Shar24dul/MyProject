package com.project.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class AddressDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String city;
	private String pincode;
}
