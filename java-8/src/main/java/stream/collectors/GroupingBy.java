package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Book {
	private Integer id;
	private String title;
	private Integer cagegoryId;
}

public class GroupingBy {

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
