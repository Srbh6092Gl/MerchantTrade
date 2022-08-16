package com.globallogic.merchanttrade.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.merchanttrade.entity.Category;
import com.globallogic.merchanttrade.entity.Merchant;
import com.globallogic.merchanttrade.entity.Product;
import com.globallogic.merchanttrade.repository.CategoryRepository;
import com.globallogic.merchanttrade.repository.MerchantRepository;
import com.globallogic.merchanttrade.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	MerchantRepository merchRepo;
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	ProductRepository prodRepo;
	
	//GET requests
	
	//GET request for fetching all Product
	@GetMapping
	public List<Product> getAllProducts(){
		return prodRepo.findAll();
	}
	
	//GET request for fetching a Product by ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) throws Exception {
		Optional<Product> response = prodRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Product not found");
		return response.get();
	}
	
	//GET request for fetching a Product by name
	@GetMapping("/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) throws Exception {
		
		List<Product> all = getAllProducts();
		if(all.isEmpty())
			throw new Exception("Product not found");
		List<Product> result = (List<Product>)all.stream().filter(p->p.getCategory().getName().equalsIgnoreCase(category)).collect(Collectors.toList());
		if(result.isEmpty())
			throw new Exception("No product in this category");
		return result;
	}
	
	//GET request for fetching a Product by name
	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable String name) throws Exception {
		Product response = prodRepo.findProductByName(name);
		if(response==null)
			throw new Exception("Product not found");
		return response;
	}
	
	
	//POST requests
	
	//POST request to add a Product
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		Optional<Merchant> merchById = merchRepo.findById(product.getMerchant().getId());
		if(merchById.isPresent()) {
			Merchant merchant = merchById.get();
			product.setMerchant(merchant);
		}
		Optional<Category> catById = catRepo.findById(product.getCategory().getId());
		if(catById.isPresent()) {
			Category category = catById.get();
			product.setCategory(category);
		}
		return prodRepo.save(product);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Product by id
	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable int id) {
		prodRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}
	
	//PUT requests
	
	//PUT request to update a Product
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return prodRepo.save(product);
	}
}