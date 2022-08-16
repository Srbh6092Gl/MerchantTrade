package com.globallogic.merchanttrade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.merchanttrade.entity.Customer;
import com.globallogic.merchanttrade.entity.Product;
import com.globallogic.merchanttrade.repository.CustomerRepository;
import com.globallogic.merchanttrade.repository.ProductRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	CustomerRepository custRepo;
	
	//GET requests
	
	//GET request for fetching all Customer
	@GetMapping
	public List<Customer> getAllCategories(){
		return custRepo.findAll();
	}
	
	//GET request for fetching a Customer by ID
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) throws Exception {
		Optional<Customer> response = custRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Customer not found");
		return response.get();
	}
	
	//GET request for fetching a Customer by name
	@GetMapping("/name/{name}")
	public Customer getCustomerByName(@PathVariable String name) throws Exception {
		Customer response = custRepo.findCustomerByName(name);
		if(response==null)
			throw new Exception("Customer not found");
		return response;
	}
	
	
	//POST requests
	
	//POST request to add a Customer
	@PostMapping
	public Customer addCustomer(@RequestBody Customer Customer) {
		return custRepo.save(Customer);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Customer by id
	@DeleteMapping("/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		custRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}
	
	//PUT requests
	
	//PUT request to update a Customer
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custRepo.save(customer);
	}
	//PUT request to update a Customer
	//If any field is missing, it will take default value for the respective field
	@PutMapping("/{id}/order/{productId}")
	public Customer order(@RequestBody Customer customer,@PathVariable int id,@PathVariable int productId) throws Exception {
		Optional<Customer> c = custRepo.findById(id);
		if(c.isEmpty())
			throw new Exception("Customer does not exist");
		Optional<Product> product = prodRepo.findById(productId);
		if(product.isEmpty())
			throw new Exception("Product does not exist");
		customer.setOrder(product.get());
		return custRepo.save(customer);
	}
	
}