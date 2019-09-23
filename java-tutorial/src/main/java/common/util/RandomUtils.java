package common.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {
	
	private RandomUtils() {
		
	}

	private static Random random = new Random();

	/**
	 * Random 1 số trong đoạn [min, max]
	 * @param min <= max
	 * @return number in [min, max]
	 */
	public static int getRandomInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return random.nextInt((max - min) + 1) + min;
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
		return IntStream.range(0, size) //
				.map(t -> getRandomInt(min, max)) //
				.boxed() //
				.collect(Collectors.toList());
	}

}
