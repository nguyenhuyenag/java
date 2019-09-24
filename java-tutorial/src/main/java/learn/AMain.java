package learn;

import java.util.Map;

import common.util.MapsUtils;
import common.util.RandomUtils;

public class AMain {

	public static void main(String[] args) {
		Map<String, Integer> map = RandomUtils.randomMap();
		// System.out.println("Map: " + map);
		// map = MapsUtils.sortByKey(map);
		// System.out.println("Sort by key: " + " " + map);
		// map = MapsUtils.sortByKeyDesc(map);
		// System.out.println("Sort by key desc: " + " " + map);
		map = MapsUtils.sortByValueDesc(map);
		System.out.println(map);
		// MapsUtils.sortByValueDesc(map).forEach((k, v) -> System.out.println(k + " => " + v));
		// System.out.println("Sort by value: " + " " + map);
		// MapsUtils.sortByValueDesc(map).forEach((k, v) -> System.out.println(k + " => " + v));
		// System.out.println("Sort by value: " + " " + map);
		// System.out.println(MapsUtils.minByKey(map));
		// System.out.println(MapsUtils.maxByKey(map));
		System.out.println(MapsUtils.minByValue(map));
		System.out.println(MapsUtils.maxByValue(map));
	}

}
