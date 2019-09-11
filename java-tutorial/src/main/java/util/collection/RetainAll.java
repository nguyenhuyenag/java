package util.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class RetainAll {

	public static void main(String[] args) {

		// Xóa các phần tử của nó khỏi danh sách không có trong bộ sưu tập đã chỉ định.

		ArrayList<Integer> objArray = new ArrayList<Integer>();
		objArray.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

		ArrayList<Integer> objArray2 = new ArrayList<Integer>();
		objArray2.addAll(Arrays.asList(0, 1, 2, 7));

		objArray.retainAll(objArray2);

		System.out.println("objArray:\t" + Arrays.toString(objArray.toArray()));
	}
}
