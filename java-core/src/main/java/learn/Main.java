package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static public void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("Java", "PHP", "SQL", "Angular 2"));

		List<String> subs = list.subList(0, 2);
		System.out.println(subs);

		// Let's modify the list size and get ConcurrentModificationException
		list.add("NodeJS");
		System.out.println(subs); // this line throws exception
		
	}

}
