package learn;

import java.util.Map;

import common.util.MapsUtils;
import common.util.RandomUtils;
import learn.collection.map.LearnMap;

public class AMain {

	public static void main(String[] args) {
		Map<String, Integer> map = RandomUtils.getMap();
		System.out.println(MapsUtils.sortByValue(map));
		System.out.println(LearnMap.findMaxValue(map));
		// System.out.println(MapsUtils.maxByValue(map));
	}

}
