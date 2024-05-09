package collection.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;

/*-
 * XOR - Finding Different Elements from Two Collections
 * 
 * Collection		Elements
 *	   A			[1, 2, 3, 4, 5, 6]
 *	   B			[3, 4, 5, 6, 7, 8, 9]
 *	A XOR B			[1, 2, 7, 8, 9]
 */
public class Different {

	public List<Integer> xor(final List<Integer> collA, final List<Integer> collB) {
		// Filter elements of A not in B
		List<Integer> listOfAnotInB = collA.stream().filter(element -> {
			return !collB.contains(element);
		}).collect(Collectors.toList());

		// Filter elements of B not in A
		List<Integer> listOfBnotInA = collB.stream().filter(element -> {
			return !collA.contains(element);
		}).collect(Collectors.toList());

		// Concatenate the two filtered lists
		return Stream.concat(listOfAnotInB.stream(), listOfBnotInA.stream()).collect(Collectors.toList());
	}
	
	public static void test() {
		List<Integer> listOne = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> listTwo = Arrays.asList(3, 4, 5, 6, 7, 8, 9);

		// System.out.println(new ArrayList<>(CollectionUtils.removeAll(listOne, listTwo)));
		// System.out.println(new ArrayList<>(CollectionUtils.removeAll(listTwo, listOne)));

		List<Integer> arrayList = new ArrayList<>(CollectionUtils.disjunction(listOne, listTwo));
		System.out.println(arrayList);
	}

	public static void main(String[] args) {
		test();
	}

}
