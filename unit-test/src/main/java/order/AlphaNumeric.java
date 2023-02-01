package order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Alphanumeric class sắp xếp và thực thi các test method theo tên, lưu ý là nó
 * phân biệt chữ hoa và chữ thường nên các ký tự hoa sẽ ưu tiên chạy trước ký tự
 * thường
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class AlphaNumeric {

	private static StringBuilder output = new StringBuilder();

	@Test
	public void myATest() {
		output.append("a");
	}

	@Test
	public void myaTest() {
		output.append("c");
	}

	@Test
	public void myBTest() {
		output.append("b");
	}

	@AfterAll
	public static void assertOutput() {
		assertEquals(output.toString(), "abc");
	}

}
