package com.basic.json.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JSONIgnore {

	@JsonIgnore
	public int id;

	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		JSONIgnore bean = new JSONIgnore(1, "My bean");
		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

}
