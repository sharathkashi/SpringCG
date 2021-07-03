package com.exam.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{
	private static final long serialVersionUID = 6325307718376939175L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="customerId")
	private Long customerId;
	@Column(name="customerName")
	private String customerName;
	@Column(name="mobileNo")
	private String mobileNo; 
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	    
		public Customer() {
			
		}

		public Customer(Long customerId, String customerName, String mobileNo, String email, String address) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.mobileNo = mobileNo;
			this.email = email;
			this.address = address;
		}

		public Customer(String customerName, String mobileNo, String email, String address) {
			super();
			this.customerName = customerName;
			this.mobileNo = mobileNo;
			this.email = email;
			this.address = address;
		}
		
		 @Override
			public String toString() {
				return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo
						+ ", email=" + email + ", address=" + address + "]";
			}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
}
