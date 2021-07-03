package com.exam.ms.dto;

public class User {
	private Integer customer_id;
	private String Email;
	private String customer_name;
	public  User()
	{
		
	}
	public User(Integer customer_id, String email, String customer_name) {
		super();
		this.customer_id = customer_id;
		Email = email;
		this.customer_name = customer_name;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "User [customer_id=" + customer_id + ", Email=" + Email + ", customer_name=" + customer_name + "]";
	}
}
