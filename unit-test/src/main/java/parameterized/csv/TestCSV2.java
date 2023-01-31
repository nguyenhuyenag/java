package parameterized.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @ValueSource: Chỉ hỗ trợ các kiểu dữ liệu nguyên thuỷ, String và Class
 *               (Boolean.class, Number.class) và không cho phép giá trị null
 *               (kể cả String)
 */
public class TestCSV2 {

	public boolean isOdd(int t) {
		return t % 2 != 0;
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE }) // six numbers
	void isOddTest(int number) {
		assertTrue(isOdd(number));
	}

	@ParameterizedTest
	@EnumSource(Month.class)
	void enumExample(Month month) {
		int monthNumber = month.getValue();
		assertTrue(monthNumber >= 1 && monthNumber <= 12);
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" })
	void someMonths_Are30DaysLong(Month month) {
		final boolean isALeapYear = false;
		assertEquals(30, month.length(isALeapYear));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, //
			names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY" }, //
			mode = EnumSource.Mode.EXCLUDE)
	void exceptFourMonths_OthersAre31DaysLong(Month month) {
		final boolean isALeapYear = false;
		assertEquals(31, month.length(isALeapYear));
	}

}
