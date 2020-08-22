package com.cranajit.rx.observables;

import java.util.concurrent.TimeUnit;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class TimerObservables {
	public static void main(String[] args) {
		Observable.timer(3, TimeUnit.SECONDS)
					.subscribe(new DemoObserver());
		RXUtils.sleep(5000l);
	}
}
