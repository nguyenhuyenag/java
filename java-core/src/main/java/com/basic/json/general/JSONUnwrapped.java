package com.basic.json.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JSONUnwrapped {

	public int id;

	@JsonUnwrapped
	public Name name;

	@AllArgsConstructor
	public static class Name {
		public String firstName;
		public String lastName;
	}

	public static void main(String[] args) throws JsonProcessingException {
		JSONUnwrapped.Name name = new JSONUnwrapped.Name("John", "Doe");
		JSONUnwrapped user = new JSONUnwrapped(1, name);

		String result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user);
		System.out.println(result);
	}

}
