package com.jadson.customers.client.soap.service;

import org.springframework.stereotype.Service;

import com.jadson.customers.client.soap.CustomerPort;
import com.jadson.customers.client.soap.CustomerPortService;
import com.jadson.customers.client.soap.DeleteCustomerRequest;
import com.jadson.customers.client.soap.DeleteCustomerResponse;
import com.jadson.customers.client.soap.GetAllCustomerDetailRequest;
import com.jadson.customers.client.soap.GetAllCustomerDetailResponse;
import com.jadson.customers.client.soap.GetCustomerDetailRequest;
import com.jadson.customers.client.soap.GetCustomerDetailResponse;
import com.jadson.customers.client.soap.connection.handler.HeaderHandlerResolver;

@Service
public class SoapServiceImpl implements SoapService{

	@Override
	public GetCustomerDetailResponse callWebService(GetCustomerDetailRequest request) {
		CustomerPort port = getCustomerPort();
		return port.getCustomerDetail(request);	
	}	

	@Override
	public GetAllCustomerDetailResponse callWebService(GetAllCustomerDetailRequest request) {
		CustomerPort port = getCustomerPort();
		return port.getAllCustomerDetail(request);	
	}

	@Override
	public DeleteCustomerResponse callWebService(DeleteCustomerRequest request) {
		CustomerPort port = getCustomerPort();
		return port.deleteCustomer(request);
	}
	
	private CustomerPort getCustomerPort() {
		CustomerPortService service = new CustomerPortService();
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		service.setHandlerResolver(handlerResolver);
		return service.getCustomerPortSoap11();
	}

}
