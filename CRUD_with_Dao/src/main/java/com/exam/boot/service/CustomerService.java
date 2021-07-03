package com.exam.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.boot.dao.CustomerDao;
import com.exam.boot.entity.Customer;
import com.exam.boot.exception.CustomerException;

@Service("CustomerService")
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerDao CustomerDao;
	@Override
	public Optional<Customer> getCustomerById(Long CustomerId) throws CustomerException {
		// TODO Auto-generated method stub
		 return CustomerDao.findById(CustomerId);
	}

	@Override
	public List<Customer> getCustomerList() throws CustomerException {
		// TODO Auto-generated method stub
		return CustomerDao.findAll();
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return CustomerDao.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		Long customerId = customer.getCustomerId();
		Optional<Customer> customerFound = getCustomerById(customerId);
		Customer updatedCustomer = null;
		if (customerFound.isPresent())
			updatedCustomer = CustomerDao.save(customer);
		return updatedCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Long customerId)  {
		// TODO Auto-generated method stub
		CustomerDao.deleteById(customerId);
		
	}

}
