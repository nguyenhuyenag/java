package learn.algorithm;

public class KhuDeQuy {

	/**
	 * @see learn.algorithm.recursion.Recursions#digitSum
	 */
	public static String toBinary(int n) {
		String str = "";
		while (n != 0) {
			str = n % 2 + str;
			n = n / 2;
		}
		return str;
	}

}
