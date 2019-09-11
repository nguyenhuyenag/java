package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Counting {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP");
		 
		Long counting = list.stream().collect(Collectors.counting());
		
		System.out.println(counting);
		
	}

}
