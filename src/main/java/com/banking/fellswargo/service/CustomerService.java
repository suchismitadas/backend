package com.banking.fellswargo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		Customer user = customerRepository.findById(Long.valueOf(username));
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
		Customer customer = customerRepository.findById(Long.valueOf(username)).orElseThrow(()-> new RuntimeException("username not found"));
		return new org.springframework.security.core.userdetails.User(String.valueOf(customer.getId()), customer.getPassword(), new ArrayList<>());
//		return customer;
	}

}
