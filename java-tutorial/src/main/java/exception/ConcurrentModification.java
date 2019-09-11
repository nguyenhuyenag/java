package exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentModification {

	/*-
	 * - ConcurrentModificationException
	 * - Khi xóa phần tử khỏi ArrayList bằng vòng lặp FOR
	 * - Không nên remove trong khi duyệt các phần tử
	 */

	static void removeByForEach(List<String> languages) {
		for (String language : languages) {
			if (language.equals("C#")) {
				languages.remove(language);
			}
		}
	}

	static void removeByIterator(List<String> languages) {
		Iterator<String> iterator = languages.iterator();
		while (iterator.hasNext()) {
			String language = iterator.next();
			if (language.equals("C#")) {
				languages.remove(language);
			}
		}
	}

	// Fix ConcurrentModificationException

	static void removeByForIndex(List<String> languages) {
		// Cách này lưu ý lỗi IndexOutOfBoundsException
		for (int i = 0; i < languages.size(); i++) {
			String language = languages.get(i);
			if (language.equals("C#")) {
				languages.remove(language);
			}
		}
		languages.forEach(System.out::println);
	}

	static void removeByIteratorMethod(List<String> languages) {
		Iterator<String> iterator = languages.iterator();
		while (iterator.hasNext()) {
			String language = iterator.next();
			if (language.equals("C#")) {
				// languages.remove(language); // Don't use ArrayList.remove()
				iterator.remove();
			}
		}
		languages.forEach(System.out::println);
	}

	static void removeAfterLoop(List<String> languages) {
		List<String> toRemove = new ArrayList<>();
		for (String language : languages) {
			if (language.equals("C#") || language.equals("Ruby")) {
				toRemove.add(language);
			}
		}
		languages.removeAll(toRemove); // [Java, PHP, C++]
		languages.forEach(System.out::println);
	}

	static void removeByRemoveIf(List<String> languages) {
		languages.removeIf(l -> (l.equals("Java") || l.equals("PHP")));
		languages.forEach(System.out::println);
	}

	static void removeByFilter(List<String> list) {
		list.stream().filter(l -> !(l.equals("Java") || l.equals("PHP"))) // xóa Java và PHP
				.collect(Collectors.toList()).forEach(System.out::println);
	}

	public static void main(String[] args) {

		List<String> languages = new ArrayList<>();

		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		// removeByForEach(languages); //	=> Exception

		// removeByIterator(languages); //	=> Exception

		// removeByForIndex(languages); // 	=> OK

		// removeByIteratorMethod(languages); // OK

		// removeAfterLoop(languages); // OK

		// removeByRemoveIf(languages); // OK

		removeByFilter(languages);	// OK
	}
}
