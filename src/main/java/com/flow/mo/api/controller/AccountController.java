package com.flow.mo.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getAccounts() {
        ResponseEntity<String> response = new ResponseEntity("",HttpStatus.OK);
        
        return response;
    }
    
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createAccount(@RequestBody String account){
		ResponseEntity<String> response= null;
		response= ResponseEntity.ok(account);
		System.out.println(account);
		
		return response;
	
	}

}