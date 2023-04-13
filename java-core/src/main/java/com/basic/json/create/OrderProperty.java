package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({ "year", "name", "version" }) // order properties
public class OrderProperty extends PrettyJson {

	public String name;
	public int year;
	public int version;

	public static void main(String[] args) throws JsonProcessingException {
		OrderProperty bean = new OrderProperty("Java", 1995, 17);
		System.out.println(bean.toJSON());
	}

}
