package com.banking.fellswargo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.fellswargo.model.Account;
//import com.banking.fellswargo.model.Customer;
import com.banking.fellswargo.service.AccountService;
//import com.banking.fellswargo.service.CustomerService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> getAllDetails() {
		return accountService.getAllAccounts();
	}
//	@GetMapping("/accounts/{id}")
//	public Account getAccountDetails(@PathVariable Integer id) {
//		Optional<Account> account = accountService.getAccounts();
//		if(!account.isPresent()) {
//			System.out.println("Account is not present");
//			return null;
//		}
//		return account.get();
//	}
//	
	@PostMapping("/accounts")
	public Account createAccount(@Valid @RequestBody Account account ) {
		return accountService.createAccount(account);
//		return account;
	}
//	
//	@PutMapping("/accounts/{id}")
//	public Account updateAccount(@PathVariable Integer id, @Valid @RequestBody Account account ) {
//		return accountService.updateAccounts(Integer id, Account account);
//	}
//	
//	@DeleteMapping("/accounts/{id}")
//	public Map<String, String> deleteAccount(@PathVariable Integer id){
//		return accountService.deleteAccounts(Integer id);
//	}
}
