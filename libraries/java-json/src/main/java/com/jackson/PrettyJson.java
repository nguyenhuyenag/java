package com.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public interface PrettyJson {

	public static final ObjectMapper objectMapper = new ObjectMapper();
	
	public default String toJSON() {
		return toJSON(objectMapper);
	}

	public default String toJSON(ObjectMapper mapper) {
		try {
			return mapper.enable(SerializationFeature.INDENT_OUTPUT) //
					.writer(new DefaultPrettyPrinter().withObjectIndenter(new DefaultIndenter("    ", "\n"))) //
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
