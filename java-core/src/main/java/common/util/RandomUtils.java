package common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {
	
	private static final Random RANDOM = new Random();
	
	private static final String ALPHA 			= 	"abcdefghijklmnopqrstuvwxyz";
	private static final String[] ARRAY_ALPHA	=	ALPHA.split("");
	private static final int LEN 				= 	ALPHA.length();

	/**
	 * Random int number in [min, max]
	 * @param min <= max is integer
	 * @return number in [min, max]
	 */
	public static int getInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return RANDOM.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Radom int number in [0, 99]
	 * @return integer number in [0, 99]
	 */
	public static int getInt() {
		return getInt(-99, 99);
	}

	/**
	 * Random int array
	 * @param size of array
	 * @param min value
	 * @param max value
	 * @return Array int
	 */
	public static int[] getArrayInt(int size, int min, int max) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = getInt(min, max);
		}
		return array;
	}
	
	public static int[] getArrayInt() {
		return getArrayInt(10, -9, 9);
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
	
	/**
	 * Random string
	 * @return string
	 */
	public static String getAlphabet() {
		int i = getInt(0, LEN - 1);
		return ARRAY_ALPHA[i];
	}

	public static Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			map.put(RandomUtils.getAlphabet().toUpperCase(), RandomUtils.getInt());
		}
		return map;
	}
	
	@Deprecated
	public static int[] pickRandom() {
		int[] arr = new Random().ints(0, 5).distinct().limit(5).toArray();
		return arr;
	}

}
