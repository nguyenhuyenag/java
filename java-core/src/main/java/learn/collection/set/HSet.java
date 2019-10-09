package learn.collection.set;

import java.util.HashSet;
import java.util.Set;

import common.util.RandomUtils;

public class HSet {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			set.add(RandomUtils.getInt());
		}
		System.out.println(set);

	}

}
