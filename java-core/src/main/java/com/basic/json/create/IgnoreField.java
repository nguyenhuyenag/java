package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @JsonIgnoreProperties({ "id" })
public class IgnoreField extends PrettyJson {

	@JsonIgnore
	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		IgnoreField bean = new IgnoreField(1, "JSON");
		System.out.println(bean.toJSON());
	}

}