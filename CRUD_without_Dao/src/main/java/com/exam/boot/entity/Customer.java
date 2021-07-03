package com.exam.boot.entity;


public class Customer {
	 private Long customerId;
	    private String customerName;
	    private String mobileNo; 
	    private String email; 
	    private String address;
	    
	    
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(Long customerId, String customerName, String mobileNo, String email, String address) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.mobileNo = mobileNo;
			this.email = email;
			this.address = address;
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
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo
					+ ", email=" + email + ", address=" + address + "]";
		}
	    
	    
}
