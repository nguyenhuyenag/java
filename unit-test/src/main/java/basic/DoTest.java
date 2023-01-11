package basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoTest {

	public int sum(int a, int b) {
		return a + b;
	}

	@Test
	public void test1() {
		assertEquals(3, sum(1, 2));
	}

}
