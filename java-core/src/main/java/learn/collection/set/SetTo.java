package learn.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class SetTo {

	static Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d"));

	public static void toArray() {
		String[] arr = set.stream().toArray(String[]::new);
	}

	public static void toList() {
		List<String> targetList = new ArrayList<>(set);
	}

}
