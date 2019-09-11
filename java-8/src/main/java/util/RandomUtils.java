package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {

	/**
	 * Random integer number in [min, max]
	 * @param min <= max
	 * @return number in [min, max]
	 */
	public static int getRandomInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	static int getRandomNumberInRangeByJava8(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();
	}

	/**
	 * Get radom Array Integer
	 * @param size
	 * @param min
	 * @param max
	 * @return Array Integer
	 */
	public static Integer[] getRandomArrayInt(int size, int min, int max) {
		Integer[] array = new Integer[size];
		for (int i = 0; i < size; i++) {
			array[i] = getRandomInt(min, max);
		}
		return array;
	}

	/**
	 * Get random List Integer
	 * @param size
	 * @param min
	 * @param max
	 * @return List Integer
	 */
	public static List<Integer> getRandomListInt(int size, int min, int max) {
		return IntStream.range(0, size).map(t -> getRandomInt(min, max)).boxed().collect(Collectors.toList());
	}

}
