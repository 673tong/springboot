package com.jinkor.model;

public class Customer {

	private Long id;
	
	private String customer_name;
	
	private Integer customer_age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Integer getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(Integer customer_age) {
		this.customer_age = customer_age;
	}
}
