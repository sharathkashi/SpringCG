package com.exam.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.boot.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{

}
