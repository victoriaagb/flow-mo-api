package com.flow.mo.api.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.mo.api.dao.AccountRepositoryImpl;
import com.flow.mo.api.dao.CombinationRepository;
import com.flow.mo.api.dao.MovesRepository;
import com.flow.mo.api.model.collection.Combination;
import com.flow.mo.api.model.collection.Move;

@Service
public class CollectionServiceImpl implements CollectionService {

	private static Logger logger = LoggerFactory.getLogger(CollectionService.class);
	
	@Autowired
	private MovesRepository movesRepository;
	
	@Autowired
	private CombinationRepository combosRepository;
	
	@Override
	public Move createNewMove(Move move) {
		//TODO: update specific fields
		move.setId(new ObjectId().toHexString());
		return movesRepository.save(move);
	}

	@Override
	public Move updateMove(Move move) {
		//TODO: make sure no two users are updating
		return movesRepository.save(move);
	}

	@Override
	public Move getMoveById(String moveId) {

		Optional<Move> moveFound = movesRepository.findById(moveId);
		return moveFound.orElse(null);
	}

	@Override
	public List<Move> getMovesInCollection(String collectionId) {
		return movesRepository.findByCollectionId(collectionId);
	}
	
	@Override
	public List<Move> removeMovesInCollection(String collectionId) {
		return movesRepository.deleteByCollectionId(collectionId);
	}
	
	@Override
	public Combination createNewCombo(Combination combo) {
		combo.setId(new ObjectId().toHexString());
		return combosRepository.save(combo);
	}

	@Override
	public Combination updateCombo(Combination combo) {
		//TODO: make sure no two users are updating
		return combosRepository.save(combo);
	}

	@Override
	public Combination getComboById(String comboId) {
		Optional<Combination> comboFound = combosRepository.findById(comboId);
		return comboFound.orElse(null);
	}

	@Override
	public List<Combination> getCombosInCollection(String collectionId) {
		return combosRepository.findByCollectionId(collectionId);
	}

	@Override
	public List<Combination> removeCombosInCollection(String collectionId) {
		return combosRepository.deleteByCollectionId(collectionId);
	}	
	
}