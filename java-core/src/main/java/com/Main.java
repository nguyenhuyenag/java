package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Collections.sort(list, (o1, o2) -> o1 - o2);
	}

}
