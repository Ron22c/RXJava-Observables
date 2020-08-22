package com.cranajit.rx.observables;

import java.util.concurrent.Callable;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class CallableObservable {
	public static String doItNow() {
		RXUtils.sleep(2000l);
		return "Ranajit";
	}
	
	public static void main(String[] args) {
		Callable<String> c = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return doItNow();
			}
		};
		
		Observable.fromCallable(c).subscribe(new DemoObserver());
	}
}
