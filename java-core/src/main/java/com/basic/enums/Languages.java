package com.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum Language {

	C("C", "001"), //
	JAVA("Java", "002"), //
	PYTHON("Python", "003"), //
	JAVASCRIPT("Javascript", "004");

	private String value;
	private String description;
	
}

public class Languages {

	public static void main(String[] args) {
		for (Language e : Language.values()) {
			System.out.println(e.getValue() + ", " + e.getDescription());
		}
	}

}
