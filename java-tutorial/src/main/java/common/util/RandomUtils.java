package common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {

	private RandomUtils() {

	}

	private static Random generator = new Random();

	/**
	 * Random int number in [min, max]
	 * @param min <= max is integer
	 * @return number in [min, max]
	 */
	public static int randomInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return generator.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Radom int number in [0, 99]
	 * @return integer number in [0, 99]
	 */
	public static int randomInt() {
		return randomInt(0, 9);
	}

	/**
	 * Random int array
	 * @param size
	 * @param min
	 * @param max
	 * @return Array Integer
	 */
	public static int[] randomArrayInt(int size, int min, int max) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = randomInt(min, max);
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
	public static List<Integer> randomListInt(int size, int min, int max) {
		return IntStream.range(0, size) //
				.map(t -> randomInt(min, max)) //
				.boxed() //
				.collect(Collectors.toList());
	}
	
	public static Map<String, Integer> randomMap() {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			map.put(RandomUtils.randomString().toUpperCase(), RandomUtils.randomInt());
		}
		return map;
	}

	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz"; // a-z
	static String[] alphaArray = ALPHA.split("");
	static int max = ALPHA.length();

	public static String randomString() {
		int intdex = randomInt(0, max - 1);
		return alphaArray[intdex];
	}

}
