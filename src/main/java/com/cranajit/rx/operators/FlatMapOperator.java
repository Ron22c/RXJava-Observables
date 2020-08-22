package com.cranajit.rx.operators;

import java.util.List;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class FlatMapOperator {
	public static void main(String[] args) {
		List<Integer> numbers = RXUtils.postiveNumbers(20);
		Observable.fromIterable(numbers)
		.flatMap(integer->twice(integer)).subscribe(new DemoObserver());
	}
	
	public static Observable<Integer> twice(Integer integer) {
		return Observable.create(emitter->{
			if(!emitter.isDisposed()) {
				emitter.onNext(integer*2);
			} else {
				emitter.onComplete();
			}
		});
	}
}
