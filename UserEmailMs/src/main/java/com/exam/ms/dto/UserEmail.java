package com.exam.ms.dto;

public class UserEmail {
private Integer customer_id;
private String Email;
public UserEmail()
{
	
}
public UserEmail(Integer customer_id, String email) {
	super();
	this.customer_id = customer_id;
	Email = email;
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
@Override
public String toString() {
	return "UserEmail [customer_id=" + customer_id + ", Email=" + Email + "]";
}
}
