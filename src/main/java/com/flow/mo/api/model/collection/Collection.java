package com.flow.mo.api.model.collection;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Collection {
	
	@Id
	@JsonProperty("collection_id")
	private String collectionId;
	
	private String name;
	
	@Transient
	private List<Move> moves;
	
	@Transient
	private List<Combination> combinations;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Collection() {
	}

	/**
	 * 
	 * @param tags
	 * @param id
	 * @param user_id
	 * @param description
	 * @param name
	 * @param favorite
	 * @param type
	 * @param url
	 */
	public Collection(String id, String name, List<Move> moves, List<Combination> combinations) {
		super();
		this.collectionId = id;
		this.name = name;
		this.moves = moves;
		this.combinations = combinations;
	}
	
	
	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String id) {
		this.collectionId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public List<Combination> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Combination> combinations) {
		this.combinations = combinations;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("moves", moves).append("combinations", combinations).toString();
	}

}