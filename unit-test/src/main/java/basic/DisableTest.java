package basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Có thể đặt @Disable trên class để vô hiệu hóa 1 class test, tuy nhiên khi đó ta
 * phải chạy nguyên package thì mới có tác dụng
 */
public class DisableTest {

	@Test
	public void test1() {
		assertEquals(2, 1 + 1);
	}

	@Disabled("Disable test method")
	@Test
	public void test2() {
		assertEquals(3, 2 + 2);
	}

}
