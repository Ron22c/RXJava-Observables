package com.cranajit.rx.filteroperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cranajit.rx.utils.RXUtils;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class IgnoreElementOperator {
	private static Logger logger = LoggerFactory.getLogger(IgnoreElementOperator.class);
	public static void main(String[] args) {
		Observable.fromIterable(RXUtils.primeNumbers(10))
				.ignoreElements()
				.subscribe(new CompletableObserver() {
			
			@Override
			public void onSubscribe(Disposable d) {
				logger.info("onSubscribe");				
			}
			
			@Override
			public void onError(Throwable e) {
				logger.info("onError");
			}
			
			@Override
			public void onComplete() {
				logger.info("onComplete");
			}
		});
	}
}
