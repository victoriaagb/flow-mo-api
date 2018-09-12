package com.flow.mo.api.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.flow.mo.api.model.repertory.Move;

public interface MovesRepository extends MongoRepository<Move, String> {
	  Move findByName(String name);
	}