package com.cranajit.rx.filteroperator;

import com.cranajit.rx.observers.DemoObserver;

import io.reactivex.Observable;

public class DistinctOperator {
	public static void main(String[] args) {
		Observable.just(1,2,3,4,5,4,3,9,1,2)
		.distinct()
		.subscribe(new DemoObserver());
	}
}
