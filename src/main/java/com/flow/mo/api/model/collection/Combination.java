package com.flow.mo.api.model.collection;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Document(collection="combinations")
public class Combination {
	
	@Id
	private String id;

	@Field("collection_id")
	private String collectionId;
	
	@DBRef
	@Field("moves_id")
	private List<Move> moves;
	
	private String name;
	
	private List<String> tags = null;
	
	private String description;
	
	private String url;
	
	private Boolean favorite;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Combination() {
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
	public Combination(String id, String collectionId, List<Move> moves, String name, List<String> tags, String description, String url, Boolean favorite) {
		super();
		this.id = id;
		this.collectionId=collectionId;
		this.moves= moves;
		this.name = name;
		this.tags = tags;
		this.description = description;
		this.url = url;
		this.favorite = favorite;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("tags", tags).append("description", description).append("moves", moves).append("url", url).append("favorite", favorite).toString();
	}

}