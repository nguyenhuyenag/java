package com;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import codewars.string.ConvertStringToCamelCase;

public class Main {

	@Test
	public void testSomeUnderscoreLowerStart() {
		String input = "the_Stealth_Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
	}

	@Test
	public void testSomeDashLowerStart() {
		String input = "the-Stealth-Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
	}

}
