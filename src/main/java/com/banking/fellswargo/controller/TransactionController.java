package com.banking.fellswargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/transactions")
	public List<Transaction> getAllDetailsByType(@RequestParam(value="type") String type){
		return transactionService.getAllTransactionsByType(type);
	}
	@PostMapping("/transactions")
	public Transaction updateTransaction(@Validated @RequestBody Transaction transaction) throws Exception {

		 boolean isValid = transactionService.validateTransaction(transaction);
		if(isValid)
			return transactionService.conductTrasaction(transaction);

		return null;
		
	}
	
	
	@GetMapping("/transactions/{account}")
	public List<Transaction> filter(@Validated @PathVariable  Integer account)
{
		return transactionService.filterTransaction(account);
		}
}
