package com.collection.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import common.object.User;
import common.util.RandomUtils;

class Book implements Comparable<Book> {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Book b) {
		return this.id < b.id ? -1 : (this.id == b.id ? 0 : 1);
	}

	@Override
	public String toString() {
		return "(" + this.id + ", " + this.name + ")";
	}

}

public class QueueWithObject {

	public static void comparing() throws InterruptedException {
		Comparator<User> cpr = Comparator.comparing(User::getName); // auto sort by name
		PriorityQueue<User> queue = new PriorityQueue<>(cpr);
		for (int i = 1; i <= 8; i++) {
			User u = new User(RandomUtils.getInt(1, 9), RandomUtils.getAlphabet().toUpperCase());
			queue.offer(u);
			System.out.println(u + " => " + queue);
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void poll() throws InterruptedException {
		Queue<Book> queue = new PriorityQueue<>();
		for (int i = 1; i <= 6; i++) {
			queue.add(new Book(RandomUtils.getInt(0, 9), RandomUtils.getAlphabet().toUpperCase()));
		}
		Iterator<Book> itr = queue.iterator();
		while (itr.hasNext()) { // !queue.isEmpty()
			System.out.println(queue.poll());
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// poll();
		comparing();
	}

}