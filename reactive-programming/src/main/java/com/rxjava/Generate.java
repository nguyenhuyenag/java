package com.rxjava;

import io.reactivex.rxjava3.core.Flowable;

public class Generate {

	public static void main(String[] args) {
		int startValue = 1;
		int incrementValue = 3;
		Flowable<Integer> flowable = Flowable.generate(() -> startValue, (s, emitter) -> {
			int nextValue = s + incrementValue;
			emitter.onNext(nextValue);
			return nextValue;
		});
		flowable.subscribe(value -> System.out.println(value));
	}

}
