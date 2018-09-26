package com.flow.mo.api.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.flow.mo.api.model.collection.Combination;

public interface CombinationRepository extends MongoRepository<Combination, String> {
	
	Combination findByName(String name);
	
	List<Combination> findByCollectionId(String collectionId);
	
	List<Combination> deleteByCollectionId(String collectionId);
}
