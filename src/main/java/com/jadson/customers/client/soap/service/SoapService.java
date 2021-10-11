package com.jadson.customers.client.soap.service;

import com.jadson.customers.client.soap.DeleteCustomerRequest;
import com.jadson.customers.client.soap.DeleteCustomerResponse;
import com.jadson.customers.client.soap.GetAllCustomerDetailRequest;
import com.jadson.customers.client.soap.GetAllCustomerDetailResponse;
import com.jadson.customers.client.soap.GetCustomerDetailRequest;
import com.jadson.customers.client.soap.GetCustomerDetailResponse;

public interface SoapService {
	
	GetCustomerDetailResponse callWebService(GetCustomerDetailRequest request);
	
	GetAllCustomerDetailResponse callWebService(GetAllCustomerDetailRequest request);
	
	DeleteCustomerResponse callWebService(DeleteCustomerRequest request);
	
}
