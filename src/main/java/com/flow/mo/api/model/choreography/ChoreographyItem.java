package com.flow.mo.api.model.choreography;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.flow.mo.api.model.collection.Combination;
import com.flow.mo.api.model.collection.Move;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ChoreographyItem {
	
	@Id
	private String id;
	
	@DBRef
	private Move move;
	
	@DBRef
	private Combination combination;
	
	private String type;
	
	private String comment;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ChoreographyItem() {
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
	public ChoreographyItem(String id, Move move, Combination combination, String type, String comment) {
		super();
		this.id = id;
		this.move = move;
		this.combination = combination;
		this.comment = comment;
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("move", move).append("combination", combination).append("comment", comment).append("type", type).toString();
	}

}