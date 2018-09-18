package com.flow.mo.api.service;

import com.flow.mo.api.model.collection.Move;

public interface CollectionService {
	
	Move createNewMove(Move move);
	
	Move updateMove(Move move);
	
	Move getMoveById(String moveId);

}