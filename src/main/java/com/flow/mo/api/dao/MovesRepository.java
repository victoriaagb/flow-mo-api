package com.flow.mo.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flow.mo.api.model.collection.Move;

public interface MovesRepository extends MongoRepository<Move, String> {
	  Move findByName(String name);
	}