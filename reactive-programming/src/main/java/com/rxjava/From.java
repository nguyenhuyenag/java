package com.rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;

public class From {

	// Flowable, Observable
	public static Observable<Integer> fromIterable() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		return Observable.fromIterable(list);
	}

	// Flowable, Observable
	public static Observable<Integer> fromArray() {
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
		return Observable.fromArray(array);
	}

	// Flowable, Observable, Maybe, Single,Completable
	public static Observable<String> fromCallable() {
		Callable<String> callable = () -> {
			System.out.println("Hello World!");
			return "Hello World!";
		};
		return Observable.fromCallable(callable);
	}

	// Maybe, Completable
	// In Completable, the actual returned value is ignored and the Completable simply completes
	public static Completable fromAction() {
		Action action = () -> System.out.println("Hello World!");
		return Completable.fromAction(action);
	}

	// Maybe, Completable
	public static Completable fromRunnable() {
		Runnable runnable = () -> System.out.println("Hello World!");
		return Completable.fromRunnable(runnable);
	}

	// Flowable, Observable, Maybe, Single, Completable
	public static Observable<String> fromFuture() {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		Future<String> future = executor.schedule(() -> "Hello world!", 1, TimeUnit.SECONDS);
		return Observable.fromFuture(future);
	}

//	public static Observable<String> fromReactiveType() {
//		Flux<Integer> reactorFlux = Flux.fromCompletionStage(CompletableFuture.<Integer>completedFuture(1));
//		return Observable.fromPublisher(reactorFlux);
//	}

	public static void main(String[] args) {

	}

}
