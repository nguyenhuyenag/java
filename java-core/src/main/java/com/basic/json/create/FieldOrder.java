package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({ "year", "name", "version" }) // order properties
public class FieldOrder extends PrettyJson {

	public String name;
	public int year;
	public int version;

	public static void main(String[] args) throws JsonProcessingException {
		FieldOrder bean = new FieldOrder("Java", 1995, 17);
		System.out.println(bean.toJSON());
	}

}
