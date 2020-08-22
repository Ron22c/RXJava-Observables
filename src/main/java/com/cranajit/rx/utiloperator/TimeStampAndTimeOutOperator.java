package com.cranajit.rx.utiloperator;

import java.util.concurrent.TimeUnit;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class TimeStampAndTimeOutOperator {
	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.shapes(10))
		.timestamp()
		.subscribe(new DemoObserver());
		
		Observable.interval(2, TimeUnit.SECONDS)
		.timeout(1, TimeUnit.SECONDS)
		.subscribe(new DemoObserver());
		
		RXUtils.sleep(5000l);
	}
}
