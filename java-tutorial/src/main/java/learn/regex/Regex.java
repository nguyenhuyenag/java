package learn.regex;

public class Regex {

	final String specialChars = "<([{\\^-=$!|]})?*+.>"; // \.[{(*+?^$|

	/*-
	 * 1.	.				-	Khớp với "1" ký tự bất kỳ
	 * 2.	^regex			-	Khớp tại điểm bắt đầu
	 * 3.	regex$			-	Khớp ở cuối dòng
	 * 4.	[abc]			-	Khớp với a hoặc b hoặc c
	 * 5.	[abc][xy]		-	Khớp a hoặc b hoặc c, theo sau là x hay y
	 * 6.	[^abc]			-	Khớp với bất kỳ trừ a hoặc b hoặc c
	 * 7.	[a-d1-7]		- 	Khớp với chuỗi giữa a và d và con số từ 1 - 7
	 * 8.	X|Z				-	Tìm X hoặc Z
	 * 9.	XZ				- 	Tìm X, theo sau là Z
	 * 10.	$				- 	Kiểm tra kết thúc dòng
	 * 
	 * 11.	\d				-	Số bất kỳ, viết ngắn gọn của [0-9]
	 * 12.	\D				-	Ký tự không phải là số, viết gọn của [^0-9]
	 * 13.	\s				-	Ký tự khoảng trắng, viết gọn của [ \t\n\x0b\r\f]
	 * 14.	\S				-	Ký tự không phải khoản trắng, viết gọn của [^\s]
	 * 15.	\w				-	Ký tự chữ, viết gọn của [a-zA-Z_0-9]
	 * 16.	\W				-	Ký tự không phải chữ, viết gọn của [^\w]
	 * 17.	\S+				-	Một số ký tự không phải khoảng trắng (một hoặc nhiều)
	 * 18.	\b				-	Ký tự thuộc a-z hoặc A-Z hoặc 0-9 hoặc _, viết gọn của [a-zA-Z0-9_].
	 * 
	 * 19.	*				-	Xuất hiện 0 hoặc nhiều lần, viết ngắn gọn cho {0,}
	 * 20.	+				-	Xuất hiện 1 hoặc nhiều lần, viết ngắn gọn cho {1,}
	 * 21.	?				-	Xuất hiện 0 hoặc 1 lần, ? viết ngắn gọn cho {0,1}
	 * 22.	{X}				-	Xuất hiện X lần, {}
	 * 23.	{X,Y}			-	Xuất hiện trong khoảng X tới Y lần
	 * 24.	*?				-	* có nghĩa là xuất hiện 0 hoặc nhiều lần, thêm ? phía sau nghĩa là tìm kiếm khớp nhỏ nhất
	 * 25.	()				-	Xác định 1 group (biểu thức con) xem như nó là một yếu tố đơn lẻ trong pattern, ví
								dụ ((a(b))c) sẽ khớp với b, ab, abc
	 * 26.	\.[{(*+?^$|		-	Ký tự đặc biệt	=> \\
	 */

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
