package basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class RepeateTest {

	public int sum(int a, int b) {
		return a + b;
	}

	@Test
	public void test1() {
		assertEquals(3, sum(1, 2));
	}

	@Test
	public void fail() {
		// Assert.fail("FAIL - Try to development");
	}

	@RepeatedTest(value = 3, name = "Method name")
	void repeatedTestWithLongName(RepetitionInfo repetitionInfo) {
		// System.out.println("Executing repeated test with long name");
		System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
		assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
	}

}
