package com.unicomer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicomer.database.Customer;
import com.unicomer.database.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		log.debug("Find all Customers.");
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findById(Long id) {
		log.debug("Find customer by id: {}", id);
		return customerRepository.findById(id);
	}
	
	public Customer create(Customer customer) {
		log.debug("Creating customer {}", customer);
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer) {
		log.debug("Updating customer {}", customer);
		return customerRepository.save(customer);
	}
	
}
