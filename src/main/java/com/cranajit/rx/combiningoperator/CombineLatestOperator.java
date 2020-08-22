package com.cranajit.rx.combiningoperator;

import java.util.concurrent.TimeUnit;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class CombineLatestOperator {
	public static void main(String[] args) {
		Observable o1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
		Observable o2 = Observable.interval(2000, TimeUnit.MILLISECONDS);
		
		Observable.combineLatest(o1, o2, (a, b) -> {
			return "first: "+a.toString()+" second: "+b.toString();
		}).take(6).subscribe(new DemoObserver());
		
		RXUtils.sleep(10000l);
	}
}
