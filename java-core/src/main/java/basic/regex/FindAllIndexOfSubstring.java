package basic.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	Cho chuỗi s và chuỗi con, tìm tất cả vị trí (start-end) của chuỗi con trong s
 */
public class FindAllIndexOfSubstring {

	public static Map<Integer, Integer> find(String str, String sub) {
		Map<Integer, Integer> map = new HashMap<>();
		Pattern pattern = Pattern.compile(sub);
		Matcher match = pattern.matcher(str);
		while (match.find()) {
			map.put(match.start(), match.end() - 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String text = "NNT NNT không thuộc đối, NNT tượng nộp loại HST này";
		String sub = "NNT";
		find(text, sub).forEach((k, v) -> System.out.println("(" + k + "," + v + ")"));
	}

}
