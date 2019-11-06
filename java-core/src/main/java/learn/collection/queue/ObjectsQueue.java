package learn.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.object.User;

public class ObjectsQueue {

	public static void main(String[] args) {
		Comparator<User> comparator = Comparator.comparing(User::getName);
		PriorityQueue<User> queue = new PriorityQueue<>(comparator);
		queue.offer(new User(5, "c"));
		queue.offer(new User(2, "b"));
		queue.offer(new User(8, "z"));
		queue.offer(new User(1, "a"));
		System.out.println(queue);
	}

}
