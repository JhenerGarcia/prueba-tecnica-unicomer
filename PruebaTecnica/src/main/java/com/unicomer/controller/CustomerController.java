package com.unicomer.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicomer.database.Customer;
import com.unicomer.dto.ApiData;
import com.unicomer.dto.ApiResult;
import com.unicomer.dto.UnicomerException;
import com.unicomer.service.CustomerService;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public ResponseEntity<ApiResult> findAll() throws UnicomerException{
		List<Customer> customers = customerService.findAll();
		return ResponseEntity.ok(new ApiResult("200", "Success", LocalDateTime.now(), new ApiData("Customers", customers)));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResult> findById(@PathVariable(name = "id") Long id) throws UnicomerException {
		Optional<Customer> optCustomer = customerService.findById(id);
		if (!optCustomer.isPresent()) {
			throw new UnicomerException(new ApiResult("404", "Customer not found.", LocalDateTime.now(), null));
		}
		return ResponseEntity
				.ok(new ApiResult("200", "Success", LocalDateTime.now(), new ApiData("Customer", optCustomer.get())));
	}

	@PostMapping()
	public ResponseEntity<ApiResult> createCustomer(@RequestBody Customer customer) throws UnicomerException {
		Customer newCustomer = customerService.create(customer);
		return ResponseEntity
				.ok(new ApiResult("201", "Success", LocalDateTime.now(), new ApiData("Customer", newCustomer)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResult> updateCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer customer)
			throws UnicomerException {
		Optional<Customer> optCustomer = customerService.findById(id);
		if (!optCustomer.isPresent()) {
			throw new UnicomerException(new ApiResult("404", "Customer not found.", LocalDateTime.now(), null));
		}
		customer.setId(optCustomer.get().getId());
		customerService.update(customer);
		return ResponseEntity
				.ok(new ApiResult("200", "Success", LocalDateTime.now(), new ApiData("Customer", customer)));
	}

}
