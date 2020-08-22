package com.cranajit.rx.observables;

import com.cranajit.rx.observers.DemoObserver;

import io.reactivex.Observable;

public class RangeObservable {
	public static void main(String[] args) {
		Observable.range(1, 10)
		.subscribe(new DemoObserver());
	}
}
