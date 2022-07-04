package com.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum Language {

	C(0, "This is C"), //
	JAVA(1, "This is Java"), //
	PYTHON(2, "This is Python"), //
	JAVASCRIPT(3, "This is Javascript");

	private int value;
	private String description;

}

public class Languages {

	public static void main(String[] args) {
		for (Language e : Language.values()) {
			System.out.println(e.name() + ", " + e.getValue() + ", " + e.getDescription());
		}
	}

}
