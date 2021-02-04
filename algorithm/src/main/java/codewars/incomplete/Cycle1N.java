package codewars.incomplete;

// https://www.codewars.com/kata/5a057ec846d843c81a0000ad
public class Cycle1N {

	public static void main(String[] args) {
		String str = String.valueOf((double) 1 / 11);
		System.out.println(str);
		String[] arr = str.split("");
		int i = str.indexOf(".") + 1;
		int len = arr.length;
		while (i < len) {
			for (int j = i; i < len; j++) {
				if (arr[i].equals(arr[j])) {
					System.out.println(str.substring(i, len));
					return;
				}
			}
			i++;
		}
	}

}
