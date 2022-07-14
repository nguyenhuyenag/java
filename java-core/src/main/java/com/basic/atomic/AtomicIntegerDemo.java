package com.basic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(3);
		// atomicInteger.accumulateAndGet(x, accumulatorFunction);
		System.out.println("addAndGet: " + atomicInteger.addAndGet(1)); // 3 + 1
		System.out.println(atomicInteger.byteValue());
		// atomicInteger.compareAndSet(expect, update)
		atomicInteger.decrementAndGet();
		atomicInteger.incrementAndGet();
		atomicInteger.getAndDecrement();
		atomicInteger.intValue();
		
		System.out.println("Final: " + atomicInteger.get());
	}

}
