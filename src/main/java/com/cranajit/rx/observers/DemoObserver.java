package com.cranajit.rx.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.observables.JustObservable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoObserver implements Observer<Object>{

	public final static Logger logger = LoggerFactory.getLogger(JustObservable.class);

	@Override
	public void onSubscribe(Disposable d) {
		logger.info("onSubscribe");
	}

	@Override
	public void onNext(Object o) {
		logger.info("onNext -> {}", o);
	}

	@Override
	public void onError(Throwable e) {
		logger.info("onError -> {}", e.getMessage());		
	}

	@Override
	public void onComplete() {
		logger.info("onComplete");
	}

}
