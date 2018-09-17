package com.flow.mo.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.mo.api.dao.MovesRepository;
import com.flow.mo.api.model.collection.Move;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private MovesRepository movesRepository;
	
	@Override
	public Move createNewMove(Move move) {
		return movesRepository.save(move);
	}

	@Override
	public Move updateMove(Move move) {
		return movesRepository.save(move);
	}

	@Override
	public Move getMoveById(String moveId) {

		Optional<Move> moveFound = movesRepository.findById(moveId);
		return moveFound.orElse(null);
	}
	
	
}