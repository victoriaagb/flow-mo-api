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
import com.flow.mo.api.service.CollectionService;

@RestController
@RequestMapping("/collection")
public class CollectionController {
	
	private static Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
	@Autowired
	private CollectionService collectionService;
	
	@PostMapping("/moves")
    public ResponseEntity<Move> postMove(@RequestBody Move move) {
		ResponseEntity<Move> response = null;
		Move updatedMove = null;
		if (move.getId() == null) {
			updatedMove = collectionService.createNewMove(move);
		}
		else {
			updatedMove = collectionService.updateMove(move);
		}
        response = new ResponseEntity<Move>(updatedMove, HttpStatus.OK);
        return response;
    }
	
	@GetMapping("/moves")
    public ResponseEntity<Move> getMoveByName(@RequestParam String moveId) {
		ResponseEntity<Move> response= null;
		Move move = collectionService.getMoveById(moveId);
		response = new ResponseEntity<Move>(move, HttpStatus.OK);
        return response;
    }
}