package com.json.preview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.json.PrettyJson;

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
class B extends A implements PrettyJson {

	String name;
	int height;
	
}

public class KeThua {

	public static void main(String[] args) throws JsonProcessingException {
		B bean = new B("Lac", 177);
		bean.setAge(24);
		System.out.println(bean.toJSON());
	}

}
