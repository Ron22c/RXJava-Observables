package com.cranajit.rx.filteroperator;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class SkipOperator {
	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.primeNumbers(10))
		.skip(5)
		.subscribe(new DemoObserver());
		
		Observable.fromIterable(RXUtils.primeNumbers(10))
		.skipLast(5)
		.subscribe(new DemoObserver());
	}
}
