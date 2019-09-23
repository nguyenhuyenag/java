package learn.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import common.util.RandomUtils;

public class FindMap {

	public static void maxByKey(Map<String, Integer> map) {
		Entry<String, Integer> max = map.entrySet().stream().max(Map.Entry.comparingByKey()).get();
		System.out.println(max);
	}

	public static void maxByValue(Map<String, Integer> map) {
		Entry<String, Integer> max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(max);
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			map.put(RandomUtils.getRandomString().toUpperCase(), RandomUtils.randomInt());
		}
		System.out.println(map);
		maxByKey(map);
		maxByValue(map);
	}

}
