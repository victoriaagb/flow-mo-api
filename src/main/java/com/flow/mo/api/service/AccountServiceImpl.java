package com.flow.mo.api.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.mo.api.dao.AccountRepository;
import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account createNewAccount(Account account) {
		account.getPerson().setPersonId(new ObjectId().toString());
		return this.accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return this.accountRepository.save(account);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return this.accountRepository.findByPersonEmail(email);
	}

	@Override
	public Account addCollection(Account account) {
		List<Collection> collections = account.getPerson().getCollections();
		int lastIndex = collections.size()-1;
		if(collections.get(lastIndex).getCollectionId()==null) {
			collections.get(lastIndex).setCollectionId(new ObjectId().toString());
		}
		return this.accountRepository.save(account);
	}
	
	
}