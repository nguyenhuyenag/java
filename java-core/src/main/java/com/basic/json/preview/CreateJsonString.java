package com.basic.json.preview;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class CreateJsonString {

	public static void main(String[] args) {
		String json = Json.createObjectBuilder() //
				.add("key1", "value1") //
				.add("key2", "value2") //
				.build() //
				.toString();
		System.out.println(json);

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder() //
				.add("name", "huyennv") //
				.add("age", "25");
		JsonObject jsonObject = jsonObjectBuilder.build();
		System.out.println(jsonObject);
	}

}
