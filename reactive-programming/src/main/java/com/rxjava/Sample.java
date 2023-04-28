package com.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class Sample {

	public static void withoutLambda() {
		final int a = 3;
		Observable<Integer> b = Observable.just(2, 5);
		b.subscribe(new Consumer<Integer>() {
			int sum = 0;

			public void accept(Integer number) throws Exception {
				sum = number + a;
				System.out.println(sum);
			}
		});
	}

	public static void lambda() {
		final int a = 3;
		Observable<Integer> b = Observable.just(2, 5);
		b.subscribe(number -> {
			int sum = a + number;
			System.out.println(sum);
		});
	}

	/**
	 * Trong thư viện RxJava thì đối tượng Observable hoặc Flowable là đại diện cho
	 * một Publisher, còn đối tượng Consumer hoặc Subscriber là đại diện cho
	 * Subscriber.
	 */
	public static void main(String[] args) {
		lambda();
		// withoutLambda();
	}

}
