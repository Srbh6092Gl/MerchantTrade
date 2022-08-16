package com.globallogic.merchanttrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.merchanttrade.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findCustomerByName(String name);
	
}