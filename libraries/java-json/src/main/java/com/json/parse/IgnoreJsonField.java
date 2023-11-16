package com.json.parse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.PrettyJson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // ignore field that exists in json but not in bean
public class IgnoreJsonField implements PrettyJson {

	private String name;
	private String address;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"name\": \"John\", \"address\": \"USA\", \"age\": 25}";

		IgnoreJsonField bean = new ObjectMapper() //
				.readerFor(IgnoreJsonField.class) //
				.readValue(json);

		System.out.println(bean.toJSON());
	}

}
