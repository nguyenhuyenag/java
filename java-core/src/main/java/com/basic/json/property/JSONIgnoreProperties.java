package com.basic.json.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonIgnoreProperties({ "id" })
public class JSONIgnoreProperties {

	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		JSONIgnoreProperties bean = new JSONIgnoreProperties(1, "My bean");
		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

}
