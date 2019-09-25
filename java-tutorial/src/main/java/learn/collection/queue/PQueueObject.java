package learn.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Book implements Comparable<Book> {

	private int id;
	@SuppressWarnings("unused")
	private String name;

	@Override
	public int compareTo(Book b) {
		if (this.id == b.id) {
			return 0;
		} else if (this.id < b.id) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}

public class PQueueObject {

	public static void main(String[] args) {

		Queue<Book> queue = new PriorityQueue<Book>();

		queue.add(new Book(121, "Let us C"));
		queue.add(new Book(233, "Operating System"));
		queue.add(new Book(101, "Data Communications & Networking"));

		System.out.println("After removing one book record:");

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
