package com.basic.json.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JACKSONInject {

	@JacksonInject
	public int id;

	public String name;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"name\": \"Injectable Values\"}";

		InjectableValues inject = new InjectableValues.Std() //
				.addValue(int.class, 1);
		JACKSONInject bean = new ObjectMapper() //
				.reader(inject) //
				.forType(JACKSONInject.class).readValue(json);
		
		System.out.println(bean.id + ", " + bean.name);
	}

}
