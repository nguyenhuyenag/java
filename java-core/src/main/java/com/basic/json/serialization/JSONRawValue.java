package com.basic.json.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JSONRawValue {

	public String name;

	@JsonRawValue
	public String json;

	public static void main(String[] args) throws JsonProcessingException {
		JSONRawValue bean = new JSONRawValue("My bean", "{\"attr\":false}");
		String result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(result);
	}

}
