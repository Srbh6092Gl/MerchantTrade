package com.globallogic.merchanttrade.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Product order;
	
	public Customer() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Product getOrder() {
		return order;
	}
	public void setOrder(Product order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", location=" + location + ", order=" + order + "]";
	}
	
}