package collection.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ListToAnotherCollection {

	static List<String> list = Arrays.asList("a", "b", "c");

	public static void toArray() {
		String[] arr1 = list.stream().toArray(String[]::new);
		String[] arr2 = list.stream().toArray(s -> new String[s]);
		String[] arr3 = list.toArray(new String[list.size()]);
		Object[] arr4 = list.toArray();
	}

	public static void toIntArray() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int[] arr = list.stream().mapToInt(t -> t).toArray();
		int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void toMap() {
		Map<String, Integer> map = list.stream() //
				.collect(Collectors.toMap(Function.identity(), String::length));
	}

	public static void toSet() {
		Set<String> set = list.stream().collect(Collectors.toCollection(HashSet::new));
		HashSet<String> hashSet = list.stream().collect(Collectors.toCollection(HashSet::new));
		TreeSet<String> treeSet = list.stream().collect(Collectors.toCollection(TreeSet::new));
	}

}
