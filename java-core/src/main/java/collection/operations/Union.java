package collection.operations;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*-
 * OR - Union of Two Collections 
 * 
 * Collection		Elements 
 * 	  A 			[9, 8, 5, 4, 7] 
 * 	  B 			[1, 3, 99, 4, 7] 
 * 	A OR B 			[9, 8, 5, 4, 7, 1, 3, 99]
 */
public class Union {

	public List<Integer> union(final List<Integer> collA, final List<Integer> collB) {
		Set<Integer> set = new LinkedHashSet<>();
		// add all elements of collection A
		set.addAll(collA);
		// add all elements of collection B
		set.addAll(collB);
		return new ArrayList<>(set);
	}

}
