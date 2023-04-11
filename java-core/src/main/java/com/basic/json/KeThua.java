package com.basic.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class A {

	String name;
	int age;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class B extends A {

	@JsonIgnore
	String name;
	int height;

}

public class KeThua {

	public static void main(String[] args) throws JsonProcessingException {
		// test();
		B bean = new B("Lac", 177);
		bean.setAge(24);
		System.out.println(new ObjectMapper().writeValueAsString(bean));
	}

}
