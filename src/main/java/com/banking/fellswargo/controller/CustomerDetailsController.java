package com.banking.fellswargo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.banking.fellswargo.exceptions.GlobalExceptionHandler;
import com.banking.fellswargo.exceptions.ResourceNotFoundException;
//import com.banking.fellswargo.jwt.JwtHelper;
import com.banking.fellswargo.model.Account;
import com.banking.fellswargo.model.Customer;
import com.banking.fellswargo.model.CustomerDetails;
import com.banking.fellswargo.model.RequestWrapper;
import com.banking.fellswargo.model.Response;
//import com.banking.fellswargo.model.JwtResponse;
import com.banking.fellswargo.service.AccountService;
//import com.banking.fellswargo.repository.CustomerDetailsRepository;
import com.banking.fellswargo.service.CustomerDetailsService;
import com.banking.fellswargo.service.CustomerService;
import com.banking.fellswargo.util.JwtUtil;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController
@CrossOrigin
public class CustomerDetailsController {

	@Autowired
	private CustomerDetailsService customerService;

	@Autowired
	private CustomerService cusS;
	@Autowired
	private AccountService accountService;

	@Autowired
	private GlobalExceptionHandler globalExceptionHandler;

	@Autowired
	private JwtUtil jwtHelper;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/customer-details")
	public List<CustomerDetails> getAllDetails() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customer-details/{id}")

	public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable Long id) throws ResourceNotFoundException {
//		try {
	
		ResponseEntity<CustomerDetails> account = customerService.getCustomerDetailsById(id);
		return account;
//		 catch(ResourceNotFoundException e) {
////			throw e;
//			globalExceptionHandler.resourceNotFoundException(e,null );
//			return null;
//		}
//		if(!account.isPresent()) {
//			System.out.println("Customer detial not  is not present");
//			return null;
//		}
//		return account.get();
	}

	@PostMapping("/register")
//	public ResponseEntity<?> createAccount(@Validated @RequestBody CustomerDetails detail, @Validated @RequestBody Customer customer) {
	public ResponseEntity<?> createAccount(@Validated @RequestBody RequestWrapper wrapper){
		CustomerDetails detail = wrapper.getCustomerDetails();
		Customer customer = wrapper.getCustomer();
		try {
			createAccountUtil(detail, customer);
		} catch(Exception e) {
		
		}
		Response  response = new Response("Account created successfully");
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
	
	public void createAccountUtil(CustomerDetails receiveddetail, Customer receivedcustomer) {
	
		Account account = new Account();
		account.setCustomer(receivedcustomer);
		receivedcustomer.getAccounts().add(account);
		
		Customer createdcustomer = cusS.createCustomer(receivedcustomer);
		account = accountService.createAccount(account);
		receiveddetail.setCustomer(createdcustomer);
		
//		consle.
		receiveddetail.setId(createdcustomer.getId());
	
		CustomerDetails createdcustomerDetails = customerService.createCustomerDetail(receiveddetail);


	}

	@PutMapping("customer-details/{id}")
	public CustomerDetails updateAccount(@PathVariable Long id, @RequestBody CustomerDetails customerDetails) {
		return customerService.updateCustomerDetail(id, customerDetails);
	}
//	
//	@DeleteMapping("/accounts/{id}")
//	public Map<String, String> deleteAccount(@PathVariable Integer id){
//		return accountService.deleteAccounts(Integer id);
//	}
}
