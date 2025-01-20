package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jackson.PrettyJson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @JsonIgnoreProperties({ "id", "name" })
public class FieldIgnore implements PrettyJson {

	@JsonIgnore
	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		FieldIgnore bean = new FieldIgnore(1, "JSON");
		System.out.println(bean.toJSON());
	}

}
