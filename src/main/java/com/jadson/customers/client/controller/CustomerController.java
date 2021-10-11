package com.jadson.customers.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jadson.customers.client.model.dto.CustomerDTO;
import com.jadson.customers.client.soap.service.CustomerSoapService;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	@Autowired
	CustomerSoapService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDTO>  find(@PathVariable Integer id) {
		CustomerDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);	
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>>  findAll() {
		List<CustomerDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);	
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String>  delete(@PathVariable Integer id,HttpServletResponse response) {
		if(service.deleteById(id)) {
			return ResponseEntity.ok("recurso excluido com sucesso!");
		}
		return ResponseEntity.notFound().build();
		
	}

}
