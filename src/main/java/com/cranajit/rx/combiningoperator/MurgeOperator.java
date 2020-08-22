package com.cranajit.rx.combiningoperator;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class MurgeOperator {
	public static void main(String[] args) {
		Observable<Shapes> shapes = Observable.fromIterable(RXUtils.shapes(5));
		Observable<Integer> size = Observable.fromIterable(RXUtils.postiveNumbers(5));
		
		Observable.merge(shapes, size).subscribe(new DemoObserver());
	}
}
