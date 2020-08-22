package com.cranajit.rx.observables;

import java.util.concurrent.TimeUnit;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class IntervalObservable {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS)
				.subscribe(new DemoObserver());
		
		RXUtils.sleep(3000l);
	}
}
