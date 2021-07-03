package com.exam.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.boot.entity.Customer;
import com.exam.boot.service.ICustomerService;





@CrossOrigin(origins = {"http://localhost:8080"}, 
allowedHeaders = "*")
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService cs;
	
	public CustomerController() {
		
	}
	
	@CrossOrigin("*")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
	
		try {
			List<Customer> customers = cs.getCustomerList();
	
			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	//getByid
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id)
	{
		Optional<Customer> customer = null;
		try {
			customer =cs.getCustomerById(id);
			if (customer.isPresent()) {
				return new ResponseEntity<>(customer.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(customer.get(),HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
		
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	//addUser
	@PostMapping(path = "/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  {
		try {
			
			Customer addedUser = cs.addCustomer(customer);
			return new ResponseEntity<>(addedUser, HttpStatus.CREATED);//201
		} catch (Exception e) {
		
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
			 {
		
		try {
			Optional<Customer> customerFound = cs.getCustomerById(id);

			if (customerFound.isPresent()) {
				cs.updateCustomer(customer);
				
				return ResponseEntity.ok(customer);
			} else {
				return new ResponseEntity<>("Record NOT updated with Id : " + customer,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>("Record NOT updated with Id : " + customer, HttpStatus.EXPECTATION_FAILED);
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		
		try {
			cs.deleteCustomer(id);
			return new ResponseEntity<>("Record Deleted...with id : "+id,HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>("Record not found with id : "+id,HttpStatus.EXPECTATION_FAILED);
		}
	}
}

