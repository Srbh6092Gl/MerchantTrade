package com.globallogic.merchanttrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.merchanttrade.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findCategoryByName(String name);
}
