package com.flow.mo.api.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.mo.api.dao.AccountRepository;
import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;
import com.flow.mo.api.model.collection.Combination;
import com.flow.mo.api.model.collection.Move;

@Service
public class AccountServiceImpl implements AccountService {

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CollectionService collectionService;
	
	@Override
	public Account createNewAccount(Account account) {
		account.getPerson().setPersonId(new ObjectId().toString());
		return this.accountRepository.insert(account);
	}

	@Override
	public Account updateAccount(Account account) {
		//TODO: update specific fields
		return this.accountRepository.save(account);
	}

	@Override
	public Account getAccountByEmail(String email) {
		Account account=null;
		account=this.accountRepository.findByPersonEmail(email);
		List<Collection> collections = setCollectionItems(account.getPerson().getCollections());
		account.getPerson().setCollections(collections);
		return account;
	}

	@Override
	public Account addCollection(Collection collection, String personId) {
		Boolean collectionAdded= false;
		Account updatedAccount = null;
		collection.setCollectionId(new ObjectId().toHexString());
		collectionAdded = accountRepository.addCollection(collection, personId);
		if(collectionAdded) {
			updatedAccount=accountRepository.findById(personId).orElse(null);
			List<Collection> collections = setCollectionItems(updatedAccount.getPerson().getCollections());
			updatedAccount.getPerson().setCollections(collections);
		}
		return updatedAccount;
	}
	
	@Override
	public Collection removeCollection(Collection collection, String personId) {
		Collection deletedCollection = null;
		Boolean collectionRemoved = false;
		String collectionId = collection.getCollectionId();
		collectionRemoved = accountRepository.removeCollection(collection, personId);
		if(collectionRemoved) {
			deletedCollection = new Collection();
			deletedCollection.setCombinations(collectionService.removeCombosInCollection(collectionId));
			deletedCollection.setMoves(collectionService.removeMovesInCollection(collectionId));
		}
		return deletedCollection;
	}
	
	private List<Collection> setCollectionItems(List<Collection> collections) {
		for(Collection collection : collections) {
			List<Combination> combos=null;
			List<Move> moves=null;
			String collectionId = collection.getCollectionId();
			moves=collectionService.getMovesInCollection(collectionId);
			combos=collectionService.getCombosInCollection(collectionId);
			collection.setMoves(moves);
			collection.setCombinations(combos);
		}
		return collections;
	}
}