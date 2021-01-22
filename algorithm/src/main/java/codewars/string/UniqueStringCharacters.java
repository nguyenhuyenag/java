package codewars.string;

import java.util.HashSet;
import java.util.Set;

// Tìm ký tự không chung của 2 chuỗi: solve("xyab","xzca") = "ybzc" 
public class UniqueStringCharacters {

	public static String solve(String a, String b) {
//		String[] arrA = a.split("");
//		String[] arrB = b.split("");
//		Set<String> common = new HashSet<>();
//		for (int i = 0; i < arrA.length; i++) {
//			for (int j = 0; j < arrB.length; j++) {
//				if (arrA[i].equals(arrB[j])) {
//					common.add(arrA[i]);
//				}
//			}
//		}
//		for (int i = 0; i < arrA.length; i++) {
//			if (common.contains(arrA[i])) {
//				arrA[i] = "";
//			}
//		}
//		for (int i = 0; i < arrB.length; i++) {
//			if (common.contains(arrB[i])) {
//				arrB[i] = "";
//			}
//		}
//		// System.out.println(Arrays.toString(arrA));
//		// System.out.println(Arrays.toString(arrB));
//		// System.out.println("common: " + common.toString());
//		return String.join("", arrA) + String.join("", arrB);
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
