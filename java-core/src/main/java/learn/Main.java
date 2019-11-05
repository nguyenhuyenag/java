package learn;

import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		int[] arr = { 1, 0, 4, 6, 17, 9, 7 };
		int len = arr.length;
		int sum = Arrays.stream(arr).sum();
		float[] fArr = new float[len];
		for (int i = 0; i < len; i++) {
			float a = (float) arr[i] / sum;
			fArr[i] = a;
		}
		System.out.println(Arrays.toString(fArr));
	}

}
