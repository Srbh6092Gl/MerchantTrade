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

import com.globallogic.merchanttrade.entity.Category;
import com.globallogic.merchanttrade.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryRepository catRepo;
	
	//GET requests
	
	//GET request for fetching all Category
	@GetMapping
	public List<Category> getAllCategorys(){
		return catRepo.findAll();
	}
	
	//GET request for fetching a Category by ID
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) throws Exception {
		Optional<Category> response = catRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Category not found");
		return response.get();
	}
	
	//GET request for fetching a Category by name
	@GetMapping("/name/{name}")
	public Category getCategoryByName(@PathVariable String name) throws Exception {
		Category response = catRepo.findCategoryByName(name);
		if(response==null)
			throw new Exception("Category not found");
		return response;
	}
	
	
	//POST requests
	
	//POST request to add a Category
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return catRepo.save(category);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Category by id
	@DeleteMapping("/{id}")
	public String deleteCategoryById(@PathVariable int id) {
		catRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}
	
	//PUT requests
	
	//PUT request to update a Category
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return catRepo.save(category);
	}
}
