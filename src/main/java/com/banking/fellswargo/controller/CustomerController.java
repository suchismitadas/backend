package com.banking.fellswargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.fellswargo.model.ChangePasswordRequest;
import com.banking.fellswargo.model.Customer;
import com.banking.fellswargo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllDetails() {
		return customerService.getAllCustomers();
	}
	
	@PutMapping("/change-password")
	public ResponseEntity<?> updatePassword(@RequestParam long id, @RequestBody ChangePasswordRequest changepaswordrequest) throws Exception {
		return customerService.updatePassword(id, changepaswordrequest);
		
	}
	 
//	@PostMapping("/forget-password?{id}")
//    public void forgetpassword(@RequestParam(value="id")int id) {
////    	bool isvalidid = customerService.get
//		retur
//    }
    

}
