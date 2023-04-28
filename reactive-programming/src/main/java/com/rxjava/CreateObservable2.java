package com.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreateObservable2 {

	// Observable.just(1, 2, 3, 4);
	public static void usingLambda() {
		Observable.create(emitter -> {
			try {
				for (int i = 0; i < 5; i++) {
					emitter.onNext(i);
				}
				emitter.onComplete();
			} catch (Exception e) {
				emitter.onError(e);
			}
		}).subscribe( //
				item -> { // onNext action
					System.out.println("Received: " + item);
				}, error -> { // onError action
					System.err.println("Error occurred: " + error);
				}, () -> { // onComplete action
					System.out.println("Completed!");
				} //
		);
	}

	public static void main(String[] args) throws InterruptedException {

		// Create the observable
		Single<String> testSingle = Single.just("Hello World");

		// Create an observer
		Disposable disposable = testSingle.delay(2, TimeUnit.SECONDS, Schedulers.io())
				.subscribeWith(new DisposableSingleObserver<String>() {
					@Override
					public void onSuccess(String value) {
						System.out.println(value);
					}

					@Override
					public void onError(Throwable e) {
						e.printStackTrace();
					}
				});
		Thread.sleep(3000);
		// start observing
		disposable.dispose();
	}

}
