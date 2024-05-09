package basic.regex;

public class Regex {

	public static void main(String[] args) {
		String regexAny = "."; // Khớp với ký tự bất kỳ
		// true
		System.out.println("a".matches(regexAny));
		// false
		System.out.println("abc".matches(regexAny)); // Chuỗi 3 ký không khớp với 1 ký tự bất kỳ
		// tre
		System.out.println("abc".matches(".*"));

		String regexFirst = "^m"; // Bắt đầu bằng chữ m
		// true
		System.out.println("m".matches(regexFirst));
		// false
		System.out.println("mnp".matches(regexFirst)); // Chuỗi 3 ký tự không khớp với 1 ký tự bất kỳ bắt đầu bởi m
		// true
		System.out.println("mnp".matches("^m.+")); // Bắt đầu bởi m sau đó là 1 ký tự bất kỳ, xuất hiện 1 hoặc nhiều lần

		String regexLast = "m$"; // Kết thúc bằng chữ m
		// true
		System.out.println("m".matches(regexLast));
		// false
		System.out.println("mnpq".matches(regexLast)); // Chuỗi 4 ký tự không khớp với 1 ký tự kết thúc là chữ m
		System.out.println("abcq".matches(".*q$")); // Chuỗi ký tự bất kỳ kết thúc bằng chữ q

		// true
		System.out.println("nnnp".matches(".n{1,3}p$")); // Ký tự bắt đầu bất kỳ, tiếp theo là ký tự n xuất hiện 1 - 3
														 // lần, kết thúc bằng ký tự p

		String s4 = "2ybcd";
		System.out.println("s4=" + s4);
		// Bắt đầu là 2
		// Tiếp theo x hoặc y hoặc z
		// Tiếp theo bất kỳ 1 hoặc nhiểu lần.
		// Kết hợp các quy tắc: [abc] , . , +
		// true
		boolean match = s4.matches("2[xyz].+");

		System.out.println("-Match 2[xyz].+ " + match);
	}

}
