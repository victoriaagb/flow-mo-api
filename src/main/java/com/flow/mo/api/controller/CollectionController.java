package com.flow.mo.api.controller;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flow.mo.api.dao.MovesRepository;
import com.flow.mo.api.model.collection.Move;

@RestController
@RequestMapping("/repertory")
public class CollectionController {
	
	private static Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
	private MovesRepository movesRepository;
	
	@Autowired
	CollectionController(MovesRepository movesRepository) {
        this.movesRepository = movesRepository;
    }
	
	@PostMapping("/moves")
    public ResponseEntity<Move> postMove(@RequestBody Move move) {
		ResponseEntity<Move> response = null;
		if (move.getId() == null) {
			//move.setId(ObjectId.get());
		}
        response = new ResponseEntity<Move>(movesRepository.save(move), HttpStatus.OK);
        return response;
    }
	
	@GetMapping("/moves")
    public ResponseEntity<Move> getMoveByName(@RequestParam String moveName) {
		ResponseEntity<Move> response= null;
		Move move = movesRepository.findByName(moveName);
		response = new ResponseEntity<Move>(move, HttpStatus.OK);
        return response;
    }
}