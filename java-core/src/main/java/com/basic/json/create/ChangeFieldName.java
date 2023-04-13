package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeFieldName extends PrettyJson {

	@JsonIgnore
	public int id;

	@JsonProperty(value = "label")
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		ChangeFieldName bean = new ChangeFieldName(1995, "Java");
		System.out.println(bean.toJSON());
	}

}
