package common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {
	
	private static Random generator = new Random();
	
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz"; // a-z
	static String[] alphaArray = ALPHA.split("");
	static int max = ALPHA.length();

	private RandomUtils() {

	}

	/**
	 * Random int number in [min, max]
	 * @param min <= max is integer
	 * @return number in [min, max]
	 */
	public static int getInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return generator.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Radom int number in [0, 99]
	 * @return integer number in [0, 99]
	 */
	public static int getInt() {
		return getInt(0, 99);
	}

	/**
	 * Random int array
	 * @param size
	 * @param min
	 * @param max
	 * @return Array Integer
	 */
	public static int[] getIntArray(int size, int min, int max) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = getInt(min, max);
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
	public static List<Integer> getListInteger(int size, int min, int max) {
		return IntStream.range(0, size) //
				.map(t -> getInt(min, max)) //
				.boxed() //
				.collect(Collectors.toList());
	}

	public static String getString() {
		int intdex = getInt(0, max - 1);
		return alphaArray[intdex];
	}

	public static Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			map.put(RandomUtils.getString().toUpperCase(), RandomUtils.getInt());
		}
		return map;
	}

}
