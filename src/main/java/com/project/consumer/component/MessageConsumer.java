package com.project.consumer.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.project.dto.EmployeeDTO;
import com.project.service.EmployeeServiceImpl;


@Component public class MessageConsumer {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(MessageConsumer.class);

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl; 
	
	@JmsListener(destination = "addEmployee-queue")
	@SendTo("addEmployee-result")
	public String	addEmployee(EmployeeDTO employeeDTO) {
		LOGGER.info("Message received! {}", employeeDTO); 
		//String result = employeeServiceImpl.addEmployee(employeeDTO);
	//	LOGGER.info("Employee added! {}", result); 
		return "ok";
	}
	
	@JmsListener(destination = "addEmployee-topic")
	public void messageListener(EmployeeDTO employeeDTO) {
		LOGGER.info("Message received! {}", "topic"); 
	}
}