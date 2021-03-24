package com.basic.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum Language {

	JAVA("Java", "001"), PYTHON("Python", "002"), C("C", "003"), JAVASCRIPT("Javascript", "004");

	private String code;
	private String des;
	
}

public class Languages {

	public static void main(String[] args) {
		System.out.println(Language.JAVA.getCode() + ": " + Language.JAVA.getDes());
		System.out.println();
		System.out.println(Arrays.toString(Language.values()));
	}

}
