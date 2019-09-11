package stream;

import java.util.Arrays;
import java.util.List;

public class MapToInt {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Geeks", "for", "gfg", "GeeksforGeeks", "GeeksQuiz");

		int[] array = list.stream().mapToInt(s -> s.length()).toArray();

		System.out.println(Arrays.toString(array));

	}

}
