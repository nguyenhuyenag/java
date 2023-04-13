package com.basic.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PrettyJson {

	private ObjectMapper objectMapper = new ObjectMapper();

	public String toJSON(ObjectMapper mapper) {
		try {
			if (mapper != null) {
				objectMapper = mapper;
			}
			return objectMapper.enable(SerializationFeature.INDENT_OUTPUT) //
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String toJSON() {
		try {
			return objectMapper.enable(SerializationFeature.INDENT_OUTPUT) //
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
