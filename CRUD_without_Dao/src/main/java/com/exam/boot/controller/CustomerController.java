package com.exam.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.boot.entity.Customer;
import com.exam.boot.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// URL:-- http://localhost:8080/customer/getCustomers
	@GetMapping("/getCustomers")
	@ResponseBody
	public List<Customer> allCustomer() {
		return customerService.allCustomer();
	}

	// URL:-- http://localhost:8080/customer/getCustomer
	@GetMapping("/getCustomer/{custId}")
	@ResponseBody
	public Customer aCustomer(@PathVariable int custId) {
		return customerService.aCustomer(custId);
	}

	// URL:-- http://localhost:8080/customer/addCustomer
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {

		String res = customerService.addCustomer(cust);
		if (res.equals("success")) {
			return new ResponseEntity<String>("successfully added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Check with Api", HttpStatus.EXPECTATION_FAILED);
		}
		/*
		 * try { customerService.addCustomer(cust); return new
		 * ResponseEntity<String>("successfully added", HttpStatus.OK); }
		 * catch(Exception e) { return new ResponseEntity<String>("Check with Api"+e,
		 * HttpStatus.EXPECTATION_FAILED); }
		 */
	}

	// URL:-- http://localhost:8080/customer/updateCustomer/{custId}

	@PutMapping("/updateCustomer/{custId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust, @PathVariable int custId) { //
		Customer res = customerService.updateCustomer(cust);
		if (res != null) {
			return new ResponseEntity<Customer>(res, HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(res, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long custId) { //
		boolean res = customerService.deleteCustomer(custId);
		System.out.println("Delete response " + res);

		if (res != false) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Request failed to delete", HttpStatus.NOT_FOUND);

	}

}
