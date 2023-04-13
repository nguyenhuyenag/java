package com.basic.json.preview;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.util.JSONUtils;

public class JSONCreator {

	public int id;
	public String name;

	@JsonCreator
	public JSONCreator(@JsonProperty("id") int id, @JsonProperty("theName") String name) {
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"id\":1000, \"theName\":\"Jackson\"}";
		JSONCreator bean = new ObjectMapper() //
				.readerFor(JSONCreator.class) //
				.readValue(json);
		System.out.println(JSONUtils.toJSON(bean));
	}

}
