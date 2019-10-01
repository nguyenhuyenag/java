package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {

	public static int getRandomInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	public static List<Integer> getRandomListInt(int size, int min, int max) {
		return IntStream.range(0, size).map(t -> getRandomInt(min, max)).boxed().collect(Collectors.toList());
	}

}
