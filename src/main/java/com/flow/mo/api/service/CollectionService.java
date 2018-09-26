package com.flow.mo.api.service;

import java.util.List;

import com.flow.mo.api.model.collection.Combination;
import com.flow.mo.api.model.collection.Move;

public interface CollectionService {
	
	Move createNewMove(Move move);
	
	Move updateMove(Move move);
	
	Move getMoveById(String moveId);
	
	List<Move> getMovesInCollection(String collectionId);
	
	List<Move> removeMovesInCollection(String collectionId);
	
	Combination createNewCombo(Combination combo);
	
	Combination updateCombo(Combination combo);
	
	Combination getComboById(String comboId);
	
	List<Combination> getCombosInCollection(String collectionId);
	
	List<Combination> removeCombosInCollection(String collectionId);

	

}