package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Limit {

	public static void main(String[] args) {

		// Init Stream iterate
		Stream<Integer> iterate = Stream.iterate(0, t -> t + 2);

		List<Integer> evenList = iterate.limit(10).collect(Collectors.toList());
		System.out.println(evenList);

		List<Integer> list = Stream.iterate(0, n -> ++n).limit(10).collect(Collectors.toList());
		System.out.println(list);
	}

}
