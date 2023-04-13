package com.basic.json.preview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class A {

	String name;
	int age;

}

@Getter
@Setter
@AllArgsConstructor
class B extends A {

	String name;
	int height;
	
	public String toJSON() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

}

public class KeThua {

	public static void main(String[] args) throws JsonProcessingException {
		B bean = new B("Lac", 177);
		bean.setAge(24);
		System.out.println(bean.toJSON());
	}

}
