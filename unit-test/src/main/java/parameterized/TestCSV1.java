package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestCSV1 {

	public int sum(int a, int b) {
		return a + b;
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void test(int a, int b, int result) {
		assertEquals(result, sum(a, b));
	}

}
