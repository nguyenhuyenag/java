package order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Sử dụng Random class để thực thi ngẫu nhiên các test method ở mỗi lần chạy,
 * như vậy thứ tự thực thi có thể khác nhau ở mỗi lần chạy.
 */
@TestMethodOrder(MethodOrderer.Random.class)
public class RandomTest {

	@Test
	void testZ() {
		assertEquals(2, 1 + 1);
	}

	@Test
	void testA() {
		assertEquals(2, 1 + 1);
	}

	@Test
	void testY() {
		assertEquals(2, 1 + 1);
	}

	@Test
	void testE() {
		assertEquals(2, 1 + 1);
	}

	@Test
	void testB() {
		assertEquals(2, 1 + 1);
	}

}
