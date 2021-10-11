package com.jadson.customers.client.soap.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadson.customers.client.model.dto.CustomerDTO;
import com.jadson.customers.client.soap.CustomerDetail;
import com.jadson.customers.client.soap.DeleteCustomerRequest;
import com.jadson.customers.client.soap.DeleteCustomerResponse;
import com.jadson.customers.client.soap.GetAllCustomerDetailRequest;
import com.jadson.customers.client.soap.GetAllCustomerDetailResponse;
import com.jadson.customers.client.soap.GetCustomerDetailRequest;
import com.jadson.customers.client.soap.GetCustomerDetailResponse;
import com.jadson.customers.client.soap.Status;

@Service
public class CustomerSoapService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SoapService service;	
	
	public CustomerDTO findById(int id) {
		GetCustomerDetailRequest request = new GetCustomerDetailRequest();
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		request.setId(id);
		response = service.callWebService(request);		
		return map(response.getCustomerDetail());		
		
	}	
	
	public List<CustomerDTO> findAll() {
		GetAllCustomerDetailRequest request = new GetAllCustomerDetailRequest();
		GetAllCustomerDetailResponse response = new GetAllCustomerDetailResponse();		
		response = service.callWebService(request);	
		return response.getCustomerDetail().stream().map(this::map).collect(Collectors.toList());		
		
	}
	
	public Boolean deleteById(int id) {
		DeleteCustomerRequest request = new DeleteCustomerRequest();
		DeleteCustomerResponse response = new DeleteCustomerResponse();
		request.setId(id);
		response = service.callWebService(request);
		return response.getStatus().equals(Status.SUCCESS)? true: false;
	}

	private CustomerDTO map(CustomerDetail c) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(c.getId());
		dto.setName(c.getName());
		dto.setEmail(c.getEmail());
		dto.setPhone(c.getPhone());		
		return dto;
	}

	

}
