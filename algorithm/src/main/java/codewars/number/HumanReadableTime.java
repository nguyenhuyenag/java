package codewars.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanReadableTime {

	public static String format(int n) {
		if (n < 9) {
			return "0" + n;
		}
		return String.valueOf(n);
	}

	public static String makeReadable(int n) {

		int h = n / (60 * 60);
		n = n - h * (60 * 60);

		int m = n / 60;
		n = n - m * 60;

		return format(h) + ":" + format(m) + ":" + format(n);
	}

	@Test
	public void Tests() {
		assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
		assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
		assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
		assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
		assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
	}

	public static void main(String[] args) {
		System.out.println(makeReadable(86399));
		// System.out.println(249609 / 3600);
	}

}
