package parameterized.csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestArray1 {

	public boolean isEvenNumber(int t) {
		return t % 2 == 0;
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data2.csv", numLinesToSkip = 1)
	void do_test(int n, boolean result) {
		// System.out.println(n);
		Assertions.assertEquals(result, isEvenNumber(n));
	}

}
