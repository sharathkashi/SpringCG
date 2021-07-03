package com.exam.boot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.boot.entity.Customer;

@Service
public class CustomerService {
	
	
	List<Customer> customersList=new ArrayList<Customer>(Arrays.asList(
			new Customer((long) 1,"sharath","9876543210","sharath@gmail.com","#4, Bangalore"),
			new Customer((long) 2,"avi","9786972342","avi@gmail.com","#2, Bangalore")));
	
	//customerList.add(new Customer(1,"sharath","9876543210","sharath@gmail.com","#4, Bangalore"));

	public List<Customer> allCustomer() {
		// TODO Auto-generated method stub
		
		return customersList;
	}

	public Customer aCustomer(int custId) {
		// TODO Auto-generated method stub
		 for(Customer cust:customersList) {
			 if(cust.getCustomerId()==custId) {
				 return cust;
			 }
		 }
		return null;
	}

	public String addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		for(Customer custList:customersList) {
			 if(custList.getCustomerId()==cust.getCustomerId()) {
				 return "failed";
			 }
		 }
		customersList.add(cust);
		return "success";
	}

	public Customer updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		for(Customer custList:customersList) {
			 if(custList.getCustomerId()==cust.getCustomerId()) {
				 custList.setCustomerName(cust.getCustomerName());
				 custList.setEmail(cust.getEmail());
				 custList.setMobileNo(cust.getMobileNo());
				 custList.setAddress(cust.getAddress());
				 return cust;
			 }
		 }
		return null;
	}

	public boolean deleteCustomer(long custId) {
		// TODO Auto-generated method stub
		boolean custDelete = customersList.removeIf(cl-> cl.getCustomerId().equals(custId));
		return custDelete;
	}

}
