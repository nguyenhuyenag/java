package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	private final AtomicInteger counter = new AtomicInteger(0);

	public int getValue() {
		return counter.get();
	}

	public void increment() {
		System.out.println("increment");
		while (true) {
			int existingValue = getValue();
			int newValue = existingValue + 1;
			if (counter.compareAndSet(existingValue, newValue)) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.increment();
	}

}
