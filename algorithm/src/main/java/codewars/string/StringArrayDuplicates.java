package codewars.string;

import java.util.Arrays;

// Xóa ký tự trùng liên tiếp trong chuỗi: assessee => asese
public class StringArrayDuplicates {

	public static String removeDuplicate(String str) {
		String[] arr = str.split("");
		String result = "", previous = "";
		for (String cur : arr) {
			if (!cur.equals(previous)) {
				result += cur;
				previous = cur;
			}
		}
		return result;
	}

	public static String[] dup(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = removeDuplicate(arr[i]);
		}
		return arr;
	}

	public static void main(String[] args) {
		String[] arr = { "abracadabra", "allottee", "assessee" };
		System.out.println(Arrays.toString(dup(arr)));
	}

}
