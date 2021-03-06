package com.flow.mo.api.model.collection;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Document(collection="moves")
public class Move {
	
	@Id
	private String id;
	
	@Field("collection_id")
	@JsonProperty("collection_id")
	private String collectionId;
	
	private String name;
	
	private List<String> tags = null;
	
	private String description;
	
	private String type;
	
	private String url;
	
	private Boolean favorite;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Move() {
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
	public Move(String id, String collectionId, String name, List<String> tags, String description, String type, String url, Boolean favorite) {
		super();
		this.id = id;
		this.collectionId=collectionId;
		this.name = name;
		this.tags = tags;
		this.description = description;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return new ToStringBuilder(this).append("name", name).append("tags", tags).append("description", description).append("type", type).append("url", url).append("favorite", favorite).toString();
	}

}