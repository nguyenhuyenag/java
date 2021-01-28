package codewars.number;

import java.math.BigInteger;

public class TheMillionthFibonacciKata {

	public static BigInteger fib(BigInteger n) {
		BigInteger NE_ONE = new BigInteger("-1");
		// < 0
		if (n.toString().charAt(0) == '-') {
			n = NE_ONE.multiply(n);
			if (n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
				return NE_ONE.multiply(fib(n));
			}
			return fib(n);
		}
		// n >= 0
		if (n.intValue() < 2) {
			return n;
		}
		int count = 1;
		BigInteger c = null;
		BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
		int vn = n.intValue();
		while (count < vn) {
			c = a.add(b);
			a = b;
			b = c;
			count++;
		}
		return c;
	}

	public static void main(String[] args) {
		BigInteger big = new BigInteger("-6");
		System.out.println(fib(big));
	}

}
