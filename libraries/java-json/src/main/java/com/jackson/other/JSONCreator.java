package com.jackson.other;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.JsonUtils;

public class JSONCreator {

	public int id;
	public String name;

	@JsonCreator
	public JSONCreator(@JsonProperty("id") int id, @JsonProperty("theName") String name) {
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) throws JsonProcessingException {
		String json = "{\"id\":1000, \"theName\":\"Jackson\"}";
		JSONCreator bean = new ObjectMapper() //
				.readerFor(JSONCreator.class) //
				.readValue(json);
		System.out.println(JsonUtils.toJSON(bean));
	}

}
