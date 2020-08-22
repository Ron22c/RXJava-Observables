package com.cranajit.rx.operators;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class ScanOperator {

	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.postiveNumbers(23))
		.scan((x,y)->x+y)
		.subscribe(new DemoObserver());
	}
}
