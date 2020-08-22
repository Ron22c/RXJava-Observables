package com.cranajit.rx.combiningoperator;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class ZipOperator {
	public static void main(String[] args) {
		Observable<Shapes> shapes = Observable.fromIterable(RXUtils.shapes(5));
		Observable<Integer> size = Observable.fromIterable(RXUtils.primeNumbers(5));
		
		shapes.zipWith(size, (o1,o2)-> {
			return o1+" : "+o2.toString();
		}).take(3).subscribe(new DemoObserver());
	}
}
