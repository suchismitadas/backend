package com.banking.fellswargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.banking.fellswargo.model.Account;
import com.banking.fellswargo.model.Transaction;
//import com.banking.fellswargo.service.AccountService;
import com.banking.fellswargo.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public List<Transaction> getAllDetails() {
		return transactionService.getAllTransactions();
	}
	
	@PostMapping("/transactions/")
	public Transaction updateTransaction(@Validated @RequestBody Transaction transaction) {
		return transactionService.conductTrasaction(transaction);
		
	}
	
	
	@GetMapping("/transactions/{account}")
	public List<Transaction> filter(@Validated @PathVariable  Integer account)
{
		return transactionService.filterTransaction(account);
		}
}
