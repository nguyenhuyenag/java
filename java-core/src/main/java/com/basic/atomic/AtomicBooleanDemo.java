package com.basic.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {

	public static void main(String[] args) {
		AtomicBoolean atomicBoolean = new AtomicBoolean(false);

		System.out.println("compareAndSet: " + atomicBoolean.compareAndSet(true, true)); // false == true ?
		
		System.out.println("getAndSet: " + atomicBoolean.getAndSet(true));

		System.out.println("Final: " + atomicBoolean.get());
	}

}
