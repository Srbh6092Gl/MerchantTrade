package com.globallogic.merchanttrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.merchanttrade.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	
	Merchant findMerchantByName(String name);
	
	Merchant findMerchantByLocation(String location);

}
