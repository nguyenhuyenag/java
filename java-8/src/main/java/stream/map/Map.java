package stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Map {


	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2", "2", "3", "3", "4", "5");
		
		ToIntFunction<String> toIntFunction = t -> Integer.valueOf(t);
		
		list.stream().map(Integer::parseInt).collect(Collectors.toList());
		list.stream().mapToInt(toIntFunction).boxed().collect(Collectors.toList());
	}

}
