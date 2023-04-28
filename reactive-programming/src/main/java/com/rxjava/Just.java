package com.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Just {

	// Available in: Flowable, Observable, Maybe, Single
	public static Observable<String> just() {
		return Observable.just("1", "A", "3.2", "def");
	}

	public static void main(String[] args) throws InterruptedException {

	}

}
