package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jackson.PrettyJson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FieldChangeName implements PrettyJson {

	@JsonIgnore
	public int id;

	@JsonProperty(value = "label")
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		FieldChangeName bean = new FieldChangeName(1995, "Java");
		System.out.println(bean.toJSON());
	}

}
