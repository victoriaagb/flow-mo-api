package com.flow.mo.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;
import com.flow.mo.api.model.collection.Move;
import com.flow.mo.api.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
    
	@PostMapping
	public ResponseEntity<Account> postAccount(@RequestBody Account account){
		ResponseEntity<Account> response = null;
		Account updatedAccount = null;	
		//new account without assigned id
		if (account.getId() == null) {
			updatedAccount = accountService.createNewAccount(account);
		}
		else{
			updatedAccount = accountService.updateAccount(account);
		}
		response= ResponseEntity.ok(updatedAccount);
		return response;
	}
	
	@GetMapping
	public ResponseEntity<Account> getAccount(@RequestParam String email){
		ResponseEntity<Account> response = null;
		Account account = null;
		account = accountService.getAccountByEmail(email);
		response= ResponseEntity.ok(account);
		return response;
	}
	
	@PostMapping("/collection")
	public ResponseEntity<Account> postCollection(@RequestBody Collection collection, @RequestParam String personId){
		ResponseEntity<Account> response = null;
		Account updatedAccount = null;	
		updatedAccount = accountService.addCollection(collection, personId);
		response= ResponseEntity.ok(updatedAccount);
		return response;
	}
	
	@DeleteMapping("/collection")
	public ResponseEntity<Collection> deleteCollection(@RequestBody Collection collection, @RequestParam String personId){
		ResponseEntity<Collection> response = null;
		Collection removedCollection = null;	
		removedCollection = accountService.removeCollection(collection, personId);
		response= ResponseEntity.ok(removedCollection);
		return response;
	}

}