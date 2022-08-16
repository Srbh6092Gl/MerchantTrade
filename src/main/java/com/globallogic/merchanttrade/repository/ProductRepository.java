package com.globallogic.merchanttrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.merchanttrade.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findProductByName(String name);

}
