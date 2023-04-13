package com.basic.json.create;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FieldRawValue {

	public String name;

	@JsonRawValue // Make field data as raw text data
	public String json;

	public static void main(String[] args) throws JsonProcessingException {
		FieldRawValue bean = new FieldRawValue("My bean", "{\"attr\":false}");
		String result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(result);
	}

}
