package codewars.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://www.codewars.com/kata/526989a41034285187000de4/
public class CountIPAddresses {

	// example : 192.168.1.2
	public static long ipToLong(String ipAddress) {
		String[] ipAddressInArray = ipAddress.split("\\.");
		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			// 192 * 256^3 + 168 * 256^2 + 1 * 256^1 + 2 * 256^0
			result += ip * Math.pow(256, power);
		}
		return result;
	}

	public static long ipsBetween(String start, String end) {
		return ipToLong(end) - ipToLong(start);
	}

	@Test
	public void ipsBetween() throws Exception {
		assertEquals(50, CountIPAddresses.ipsBetween("10.0.0.0", "10.0.0.50"));
		assertEquals(246, CountIPAddresses.ipsBetween("20.0.0.10", "20.0.1.0"));
	}

}
