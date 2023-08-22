package com.banking.fellswargo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.fellswargo.model.ChangePasswordRequest;
import com.banking.fellswargo.model.Customer;
import com.banking.fellswargo.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByEmailId(String email) {
		return customerRepository.findByEmailId(email);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		Customer user = customerRepository.findById(Long.valueOf(username));
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
		Customer customer = customerRepository.findById(Long.valueOf(username)).orElseThrow(()-> new RuntimeException("username not found"));
		return new org.springframework.security.core.userdetails.User(String.valueOf(customer.getId()), customer.getPassword(), new ArrayList<>());
//		return customer;
	}
//	public Customer get

	public ResponseEntity<?> updatePassword(long id, ChangePasswordRequest changepaswordrequest) throws Exception{
		// TODO Auto-generated method stub
		if(changepaswordrequest.getNewPassword().equals(changepaswordrequest.getOldPassword()))
			throw new Exception("You already know your password");
		Customer customer = getCustomerById(id);
		if(!customer.getPassword().equals(changepaswordrequest.getOldPassword())) {
			
			throw new Exception("Old password does not maptch");
		}
		customer.setPassword(changepaswordrequest.getNewPassword());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}

	private Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
//		return null;
	}

}
