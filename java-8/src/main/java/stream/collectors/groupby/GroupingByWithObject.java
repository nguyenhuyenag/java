package stream.collectors.groupby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Book {
	
	private Integer id;
	private String title;
	private int cagegoryId;

}

public class GroupingByWithObject {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(//
				new Book(1, "A", 1), //
				new Book(2, "B", 1), //
				new Book(3, "C", 2), //
				new Book(4, "D", 3), //
				new Book(5, "E", 1) //
		);

		Map<Integer, Set<Book>> result = books.stream() //
				.collect(Collectors.groupingBy(Book::getCagegoryId, Collectors.toSet()));

		result.forEach((catId, booksInCat) -> System.out.println("Category " + catId + " : " + booksInCat.size()));
	}

}
