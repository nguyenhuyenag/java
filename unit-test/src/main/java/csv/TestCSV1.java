package csv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestCSV1 {

	public int sum(int a, int b) {
		return a + b;
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void test(int a, int b, int result) {
		assertEquals(result, sum(a, b));
	}

}
