package string;

import java.util.StringJoiner;

public class JoinerString {

	public static void ex1() {
		StringJoiner sj = new StringJoiner("-");
		sj.add("1");
		sj.add("2");
		System.out.println(sj.toString());
	}

	// StringJoiner(delimiter, prefix, suffix)
	public static void ex2() {
		StringJoiner sj = new StringJoiner("-", "[", "]");
		sj.add("A");
		sj.add("B");
		sj.add("C");
		System.out.println(sj.toString());
	}

	public static void main(String[] args) {
		ex1();
		ex2();
	}

}
