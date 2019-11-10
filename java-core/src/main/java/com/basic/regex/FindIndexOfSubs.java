package com.basic.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindIndexOfSubs {

	static Map<Integer, Integer> find(String str, String sub) {
		Map<Integer, Integer> map = new HashMap<>();
		Pattern pattern = Pattern.compile(sub);
		Matcher match = pattern.matcher(str);
		while (match.find()) {
			map.put(match.start(), match.end() - 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String text = "NNT NNT không thuộc đối, NNT tượng nộp loại HSKT này";
		String sub = "NNT";
		find(text, sub).forEach((k, v) -> System.out.println("[" + k + "-" + v + "]"));
	}

}
