package com.banking.fellswargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.fellswargo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccountNumber(Integer number);
//	public Account find

}
