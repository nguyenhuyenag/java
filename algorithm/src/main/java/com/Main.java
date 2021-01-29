package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {

//	@Test
//	public void testSomeUnderscoreLowerStart() {
//		String input = "the_Stealth_Warrior";
//		System.out.println("input: " + input);
//		assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
//	}
//
//	@Test
//	public void testSomeDashLowerStart() {
//		String input = "the-Stealth-Warrior";
//		System.out.println("input: " + input);
//		assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
//	}

	public static int max(int... arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	public static int expressionsMatter(int a, int b, int c) {
		return max(a + b + c, a * b * c, a + b * c, a * b + c, (a + b) * c, a * (b + c));
	}

	@Test
	public void checkSmallValues() {
		assertEquals(6, Main.expressionsMatter(2, 1, 2));
		assertEquals(3, Main.expressionsMatter(1, 1, 1));
		assertEquals(4, Main.expressionsMatter(2, 1, 1));
		assertEquals(9, Main.expressionsMatter(1, 2, 3));
		assertEquals(5, Main.expressionsMatter(1, 3, 1));
		assertEquals(8, Main.expressionsMatter(2, 2, 2));
	}

	@Test
	public void checkIntermediateValues() {
		assertEquals(20, Main.expressionsMatter(5, 1, 3));
		assertEquals(105, Main.expressionsMatter(3, 5, 7));
		assertEquals(35, Main.expressionsMatter(5, 6, 1));
		assertEquals(8, Main.expressionsMatter(1, 6, 1));
		assertEquals(14, Main.expressionsMatter(2, 6, 1));
		assertEquals(48, Main.expressionsMatter(6, 7, 1));
	}

	@Test
	public void checkMixedValues() {
		assertEquals(60, Main.expressionsMatter(2, 10, 3));
		assertEquals(27, Main.expressionsMatter(1, 8, 3));
		assertEquals(126, Main.expressionsMatter(9, 7, 2));
		assertEquals(20, Main.expressionsMatter(1, 1, 10));
		assertEquals(18, Main.expressionsMatter(9, 1, 1));
		assertEquals(300, Main.expressionsMatter(10, 5, 6));
		assertEquals(12, Main.expressionsMatter(1, 10, 1));
	}

}
