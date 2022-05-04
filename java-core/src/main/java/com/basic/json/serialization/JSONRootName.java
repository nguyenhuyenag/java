package com.basic.json.serialization;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;

@JsonRootName(value = "_USER")
@AllArgsConstructor
public class JSONRootName {

	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		JSONRootName bean = new JSONRootName(2, "Java");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE); // wrapping is enabled
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = mapper.writeValueAsString(bean);
		System.out.println(result);
	}

}
