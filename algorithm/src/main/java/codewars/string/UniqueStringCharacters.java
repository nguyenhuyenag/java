package codewars.string;

// Tìm ký tự không chung của 2 chuỗi: solve("xyab","xzca") = "ybzc" 
public class UniqueStringCharacters {

	public static String solve(String a, String b) {
		String result = "";
		for (String s : (a + b).split("")) {
			if (a.indexOf(s) == -1 || b.indexOf(s) == -1) {
				result += s;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solve("[]xyzabyyyy", "xyyyz[]ca"));
	}
}
