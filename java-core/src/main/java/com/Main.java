package com;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum Enums {
	
	MSG_0(0, "This is 0"),
	MSG_1(1, "This is 1"),
	MSG_2(2, "This is 2");
	
	private int value;
	private String description;
}

public class Main {

	public static void main(String[] args) {
		int v = 0;
		for (Enums e : Enums.values()) {
			System.out.println(e.getValue() + ", " + e.getDescription());
		}
	}

}
