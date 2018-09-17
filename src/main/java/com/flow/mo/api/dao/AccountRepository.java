package com.flow.mo.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flow.mo.api.model.account.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	  Account findByPersonEmail(String email);
}