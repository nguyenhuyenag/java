package learn.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetainAll {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.addAll(Arrays.asList(0, 2, 4));
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(Arrays.asList(0, 1, 2, 3));
		System.out.println("List1: " + list1);
		System.out.println("List2: " + list2);
		// Xóa những phần tử của list1 không có trong list2
		list1.retainAll(list2);
		// 0 có trong list1, có trong list2			=> giữa lại
		// 2 có trong list1, có trong list2			=> giữ lại
		// 4 có trong list1, không có trong list2	=>	xóa
		// kết quá [0, 2]
		System.out.println("List1: " + list1);
	}
}
