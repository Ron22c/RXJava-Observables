package com.cranajit.rx.filteroperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class TakeOperator {
	Logger logger = LoggerFactory.getLogger(TakeOperator.class);
	
	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.postiveNumbers(10))
		.take(5)
		.subscribe(new DemoObserver());
		
		Observable.fromIterable(RXUtils.postiveNumbers(10))
		.takeLast(5)
		.subscribe(new DemoObserver());
		
	}
}
