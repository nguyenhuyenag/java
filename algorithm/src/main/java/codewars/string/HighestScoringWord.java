package codewars.string;

// Giả sử a = 1, b = 2, ... In ra từ có giá trị lớn nhất trong chuỗi
// "man i need a taxi up to ubud" => taxi
public class HighestScoringWord {

	public static int valueOfString(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += ((int) str.charAt(i) - 96);
		}
		return sum;
	}

	public static String high(String s) {
		String[] arr = s.split(" ");
		int indexMax = 0;
		int max = valueOfString(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			int v = valueOfString(arr[i]);
			if (v > max) {
				max = v;
				indexMax = i;
			}
		}
		return arr[indexMax];
	}

	public static void main(String[] args) {
		System.out.println(high("man i need a taxi up to ubud"));
	}

}
