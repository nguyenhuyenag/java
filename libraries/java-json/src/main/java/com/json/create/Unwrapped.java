package com.json.create;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.json.PrettyJson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Unwrapped implements PrettyJson {

	public int id;

	@JsonUnwrapped // Đóng mở dòng này và run
	public Name name;

	@AllArgsConstructor
	static class Name {
		public String firstName;
		public String lastName;
	}

	public static void main(String[] args) throws JsonProcessingException {
		Name name = new Name("John", "Doe");
		Unwrapped bean = new Unwrapped(123, name);
		System.out.println(bean.toJSON());
	}

}
