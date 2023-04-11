package com.basic.json.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({ "name", "id" }) // order of properties on serialization
public class OrderProperty {

	public int id;
    public String name;

	public static void main(String[] args) throws JsonProcessingException {
		OrderProperty bean = new OrderProperty(2, "Java");
		String result = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(bean);
		System.out.println(result);
	}

}
