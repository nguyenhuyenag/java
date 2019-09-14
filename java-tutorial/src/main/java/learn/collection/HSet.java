package learn.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HSet {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			set.add(i);
		}
		// Kiếm tra giá trị x có thuộc set
		int x = 1;
		System.out.println(set.contains(x));
		// Duyệt set
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			int n = iterator.next();
			if (n == x) {
				System.out.println(n);
				return;
			}
		}
	}

}
