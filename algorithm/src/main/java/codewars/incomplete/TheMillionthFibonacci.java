package codewars.incomplete;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TheMillionthFibonacci {

	private static Map<String, BigInteger> list = new HashMap<>();

	public static BigInteger init(BigInteger n) {
		list.put("0", BigInteger.ZERO);
		list.put("1", BigInteger.ONE);
		
		return list.get(n.toString());
	}

	public static BigInteger fib(BigInteger fb) {
		return null;
	}

	public static void main(String[] args) {
		
	}

}
