package com.cranajit.rx.filteroperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.utils.RXUtils;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ElementAtOperators {
	private static Logger logger = LoggerFactory.getLogger(ElementAtOperators.class); 
	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.postiveNumbers(10))
		.elementAt(12)
		.subscribe(new MaybeObserver<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				logger.info("onSubscribe");
			}

			@Override
			public void onSuccess(Integer t) {
				logger.info("onSuccess -> {}", t);				
			}

			@Override
			public void onError(Throwable e) {
				logger.info("onError -> {}", e);
			}

			@Override
			public void onComplete() {
				logger.info("onComplete");
			}
		});
	}
}
