package com.banking.fellswargo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.banking.fellswargo.model.Account;
import com.banking.fellswargo.model.Transaction;
import com.banking.fellswargo.repository.AccountRepository;
//import com.banking.fellswargo.repository.AccountRepository;
import com.banking.fellswargo.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountService accountService;
	public List<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
	}
	
	public Transaction conductTrasaction(Transaction transaction) {
		// have to write the transaction logic
		accountService.updateAccount(transaction.getFromAccount(), -1*transaction.getAmount());
		accountService.updateAccount(transaction.getToAccount(), transaction.getAmount());
		return transactionRepository.save(transaction);
//		return transaction;
	}
	
	public List<Transaction> filterTransaction(int accountNumber) {
		return transactionRepository.findByFromAccountOrToAccount(accountNumber, accountNumber);
	}
}
