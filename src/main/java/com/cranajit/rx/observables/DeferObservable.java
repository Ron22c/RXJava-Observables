package com.cranajit.rx.observables;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class DeferObservable {
	public static void main(String[] args) {
		Observable<Shapes> obs = Observable.defer(()->{
			return Observable.fromIterable(RXUtils.shapes(10));
		});
		
		obs.subscribe(new DemoObserver());
		obs.subscribe(new DemoObserver());
	}
}
