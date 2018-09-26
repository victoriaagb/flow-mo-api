package com.flow.mo.api.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flow.mo.api.model.collection.Move;

public interface MovesRepository extends MongoRepository<Move, String> {
	  
	Move findByName(String name);
	
	List<Move> findByCollectionId(String collectionId);
	
	List<Move> deleteByCollectionId(String collectionId);
}