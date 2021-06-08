package common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
		if (max <= min) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return RANDOM.nextInt((max - min) + 1) + min;
	}
	
	public static int randomIntFrom(int min, int max) {
		if (max <= min) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public <T> T randomFromList(List<T> list) {
		int index = randomIntFrom(0, list.size() - 1);
		return list.get(index);
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
			map.put(getAlphabet().toUpperCase(), getInt(-99, 99));
		}
		return map;
	}
	
	public static double rand(double min, double max) {
		// double min = 0.85;
		// double max = 1.0;
		return Math.random() * (max - min) + min;
	}
	
	public static void rand() {
		Random ran = new Random();
		int cur, pre = ran.nextInt(4);
		for (int i = 0; i < 10; i++) {
			cur = ran.nextInt(4);
			while (cur == pre) {
				cur = ran.nextInt(4);
			}
			pre = cur;
			System.out.println(cur);
		}
	}
	
	@Deprecated
	public static int[] pickRandom() {
		return new Random().ints(0, 5).distinct().limit(5).toArray();
	}
	
}
