package com;

import com.basic.json.general.JSONProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.util.JSONUtils;

public class Main {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"_id\": 12, \"name\": \"Green\"}";
		JSONProperty bean = new ObjectMapper().readerFor(JSONProperty.class).readValue(json);
		System.out.println(JSONUtils.toJSON(bean));
	}

}
