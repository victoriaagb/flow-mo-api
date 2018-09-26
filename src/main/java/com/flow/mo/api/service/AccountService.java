package com.flow.mo.api.service;

import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;

public interface AccountService {
	
	Account createNewAccount(Account account);
	
	Account updateAccount(Account account);
	
	Account getAccountByEmail(String email);

	Account addCollection(Collection collection, String personId);

	Collection removeCollection(Collection collection, String personId);
}