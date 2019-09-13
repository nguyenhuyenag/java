package common.util.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

public class JoinArray {

	public static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(t -> Arrays.deepToString(t)) //
				.collect(Collectors.joining(" + "));
	}

	public static void main(String[] args) {

		String[] s1 = { "a", "b", "c" };
		String[] s2 = new String[] { "d", "e", "f" };
		String[] join = ArrayUtils.addAll(s1, s2);
		System.out.println(print(s1, s2) + " = " + print(join));

	}

}
