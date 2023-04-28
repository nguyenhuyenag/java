package com.rxjava;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class Create {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		ObservableOnSubscribe<String> handler = emitter -> {

			Future<?> future = executor.schedule(() -> {
				emitter.onNext("Hello");
				emitter.onNext("World");
				emitter.onComplete();
			}, 1, TimeUnit.SECONDS);

			emitter.setCancellable(() -> future.cancel(false));
		};

		Observable<String> observable = Observable.create(handler);

		observable.subscribe(item -> System.out.println(item), error -> error.printStackTrace(),
				() -> System.out.println("Done"));

		Thread.sleep(2000);
		executor.shutdown();
	}

}
