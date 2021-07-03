package com.exam.boot.service;

import java.util.List;
import java.util.Optional;

import com.exam.boot.entity.Customer;
import com.exam.boot.exception.CustomerException;

public interface ICustomerService {
	
		public Optional<Customer> getCustomerById(Long CustomerId) throws CustomerException;
		public List<Customer> getCustomerList()throws CustomerException;
		public Customer addCustomer(Customer customer) throws CustomerException;

		public Customer updateCustomer(Customer customer)throws CustomerException;
		public void deleteCustomer(Long CustomerId)throws CustomerException; 
	

}
