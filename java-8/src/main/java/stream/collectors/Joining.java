package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

	/*-
	 * - Delimiter	: chuỗi ký tự phân tách các phần tử
	 * - Prefix 	: chuỗi ký tự được thêm vào đầu kết quả
	 * - Suffix		: chuỗi ký tự được thêm vào cuối kết quả
	 */

	public static void main(String[] args) {
		List<String> list = Arrays.asList("public", "static", "void", "main");
		System.out.println(list.stream().collect(Collectors.joining()));
		System.out.println(list.stream().collect(Collectors.joining(" - ")));
		System.out.println(list.stream().collect(Collectors.joining(" ", "PRE-", "-POST")));
	}

}
