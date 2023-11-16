package com.json.create;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.json.PrettyJson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({ "year", "name", "version" }) // order properties
public class FieldSort implements PrettyJson {

	public String name;
	public int year;
	public int version;

	public static void main(String[] args) throws JsonProcessingException {
		FieldSort bean = new FieldSort("Java", 1995, 17);
		System.out.println(bean.toJSON());
	}

}
