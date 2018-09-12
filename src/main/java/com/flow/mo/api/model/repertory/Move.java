package com.flow.mo.api.model.repertory;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Move {
	
	@Id
	private ObjectId _id;
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
	 * @param description
	 * @param name
	 * @param favorite
	 * @param type
	 * @param url
	 */
	public Move(ObjectId id, String name, List<String> tags, String description, String type, String url, Boolean favorite) {
		super();
		this._id = id;
		this.name = name;
		this.tags = tags;
		this.description = description;
		this.type = type;
		this.url = url;
		this.favorite = favorite;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
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