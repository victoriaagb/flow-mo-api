package com.flow.mo.api.model.choreography;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Document(collection="choreographies")
public class Choreography {
	
	@Id
	private String id;
	
	private String name;
	
	private List<String> tags = null;
	
	private String description;

	private List<ChoreographyItem> items;
	
	private String url;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Choreography() {
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
	public Choreography(String id, String name, List<String> tags, String description, List<ChoreographyItem> items, String url, List<String> comments) {
		super();
		this.id = id;
		this.name = name;
		this.tags = tags;
		this.description = description;
		this.items = items;
		this.url = url;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<ChoreographyItem> getItems() {
		return items;
	}

	public void setItems(List<ChoreographyItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("tags", tags).append("description", description).append("url", url).append("Items", items).toString();
	}

}