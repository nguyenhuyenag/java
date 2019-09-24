package learn.collection.map;

import java.util.Map;
import java.util.Map.Entry;

import common.util.MapsUtils;

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
		Map<String, Integer> map = MapsUtils.randomMap();
		// System.out.println(map);
		// maxByKey(map);
		// maxByValue(map);
		System.out.println(MapsUtils.sortByKey(map));
		// System.out.println(MapsUtils.sortByKeyDesc(map));
		// MapsUtils.sortByValue(map).forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
		// MapsUtils.sortByValueDesc(map).forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
		System.out.println(MapsUtils.findMinByKey(map));
		System.out.println(MapsUtils.findMaxByKey(map));
	}

}
