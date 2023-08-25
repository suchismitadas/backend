package com.banking.fellswargo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.banking.fellswargo.model.Account;
import com.banking.fellswargo.service.AccountService;

@SpringBootTest
class AccountServiceTests {

	AccountService accountService;
	
	
	@BeforeAll
	void createAccount() {
		 accountService = new AccountService();
	}
	@Test
	void testAccountCount() {
//		AccountService accountService = new AccountService();
		
//		assertEquals(10, accountService.getAllAccounts().size());
	}
	
	@Test
	void testUpdateAccount() {
		Account oldAccount = accountService.getAccount(123);
		Account newAccount = accountService.updateAccount(123, 10);
		
		assertEquals(10+oldAccount.getBalance(),newAccount.getBalance());
//		accountService.createAccount(123);
	}

}
