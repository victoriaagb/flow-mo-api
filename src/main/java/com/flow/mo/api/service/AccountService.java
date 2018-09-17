package com.flow.mo.api.service;

import com.flow.mo.api.model.account.Account;

public interface AccountService {
	
	Account createNewAccount(Account account);
	
	Account updateAccount(Account account);
	
	Account getAccountByEmail(String email);
	
	Account addCollection(Account account);
}