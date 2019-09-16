package learn.collection.list;

import java.util.Arrays;
import java.util.List;

public class ToArray {

	static <T> void getType(T object) {
		System.out.println(object.getClass().getSimpleName());
	}

	public static String[] useStream1(List<String> list) {
		return list.stream().toArray(String[]::new);
	}

	public static String[] useStream2(List<String> list) {
		return list.stream().toArray(s -> new String[s]);
	}

	public static Object[] useToArray1(List<String> list) {
		return list.toArray();
	}

	public static String[] useToArray2(List<String> list) {
		return list.toArray(new String[list.size()]);
	}

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "c");

		String[] strings = useStream1(list);
		getType(strings);

		String[] array = useStream2(list);
		getType(array);

		Object[] array1 = useToArray1(list);
		getType(array1);

		String[] stockArr = useToArray2(list);
		getType(stockArr);

	}

}
