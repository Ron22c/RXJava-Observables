package com.cranajit.rx.operators;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MapOperator {
	public static void main(String[] args) {
		Observable.create(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				try {
					RXUtils.postiveNumbers(25).forEach(num->emitter.onNext(num));
				} catch(Exception e) {
					emitter.onError(e);
				}
				emitter.onComplete();
			}
		}).map(num->num*2).subscribe(new DemoObserver());
	}
}
