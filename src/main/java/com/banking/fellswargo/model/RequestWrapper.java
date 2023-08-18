package com.banking.fellswargo.model;

public class RequestWrapper {
	private CustomerDetails customerDetails;
	private Customer customer;
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public RequestWrapper() {
		
		
	}
	public RequestWrapper(CustomerDetails customerDetails, Customer customer) {
		super();
		this.customerDetails = customerDetails;
		this.customer = customer;
	}
}
