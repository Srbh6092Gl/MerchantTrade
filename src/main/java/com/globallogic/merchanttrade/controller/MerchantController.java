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

import com.globallogic.merchanttrade.entity.Merchant;
import com.globallogic.merchanttrade.repository.MerchantRepository;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired
	MerchantRepository merchRepo;
	
	//GET requests
	
	//GET request for fetching all merchant
	@GetMapping
	public List<Merchant> getAllMerchants(){
		return merchRepo.findAll();
	}
	
	//GET request for fetching a merchant by ID
	@GetMapping("/{id}")
	public Merchant getMerchantById(@PathVariable int id) throws Exception {
		Optional<Merchant> response = merchRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Merchant not found");
		return response.get();
	}
	
	//GET request for fetching a merchant by name
	@GetMapping("/name/{name}")
	public Merchant getMerchantByName(@PathVariable String name) throws Exception {
		Merchant response = merchRepo.findMerchantByName(name);
		if(response==null)
			throw new Exception("Merchant not found");
		return response;
	}
	
	//GET request for fetching a merchant by location
	@GetMapping("/location/{location}")
	public Merchant getMerchantByLocation(@PathVariable String location) throws Exception {
		Merchant response = merchRepo.findMerchantByLocation(location);
		if(response==null)
			throw new Exception("Merchant not found");
		return response;
	}
	
	
	//POST requests
	
	//POST request to add a merchant
	@PostMapping
	public Merchant addMerchant(@RequestBody Merchant merchant) {
		return merchRepo.save(merchant);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a merchant by id
	@DeleteMapping("/{id}")
	public String deleteMerchantById(@PathVariable int id) {
		merchRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}
	
	//PUT requests
	
	//PUT request to update a merchant
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Merchant updateMerchant(@RequestBody Merchant merchant) {
		return merchRepo.save(merchant);
	}
}
