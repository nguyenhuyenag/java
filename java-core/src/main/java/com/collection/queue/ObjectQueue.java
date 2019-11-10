package com.collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import common.util.RandomUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SuppressWarnings("unused")
class Book implements Comparable<Book> {

	private int id;
	private String name;

	@Override
	public int compareTo(Book b) {
		return this.id < b.id ? -1 : (this.id == b.id ? 0 : 1);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}

public class ObjectQueue {

	public static void main(String[] args) throws InterruptedException {
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

}
