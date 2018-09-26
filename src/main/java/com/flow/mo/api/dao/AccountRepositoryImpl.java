package com.flow.mo.api.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;
import com.mongodb.MongoException;
import com.mongodb.client.result.UpdateResult;

@Repository
public class AccountRepositoryImpl implements AccountRepositoryCustom {
	
	private static Logger logger = LoggerFactory.getLogger(AccountRepositoryImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean addCollection(Collection collection, String personId) {
		Query query = new Query();
		Update update = new Update();
		boolean collectionAdded = false;
		
		try {
			query.addCriteria(Criteria.where("_id").is(personId));
			update.push("collections", collection);
			UpdateResult result = mongoTemplate.updateFirst(
					query, 
					update,
					Account.class);
			collectionAdded=result.getModifiedCount() > 0;
		} catch (MongoException e) {
			logger.error("Error while pushing new collection: ", e);
		}
		return collectionAdded;
	}

	@Override
	public boolean removeCollection(Collection collection, String personId) {
		Query query = new Query();
		Update update = new Update();
		boolean collectionRemoved = false;
		
		try {
			query.addCriteria(Criteria.where("_id").is(personId));
			update.pull("collections", query);
			UpdateResult result = mongoTemplate.updateFirst(
					query, 
					update,
					Account.class);
			collectionRemoved=result.getModifiedCount() > 0;
		} catch (MongoException e) {
			logger.error("Error while pushing new collection: ", e);
		}
		return collectionRemoved;
	}
}
