package com.cranajit.rx.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class GroupByOperator {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(GroupByOperator.class);
		Observable.fromIterable(RXUtils.shapes(20))
		.groupBy(new Function<Shapes, Object>() {

			@Override
			public Object apply(Shapes t) throws Exception {
				return t.getShape();
			}
			
		}).observeOn(Schedulers.newThread())
		.subscribe(new Observer<GroupedObservable<Object, Shapes>>() {

			@Override
			public void onSubscribe(Disposable d) {
				logger.info("onSubscribe");				
			}

			@Override
			public void onNext(GroupedObservable<Object, Shapes> t) {
				logger.info("KEY: {}", t.getKey());
				t.subscribe(new DemoObserver());
				
			}

			@Override
			public void onError(Throwable e) {
				logger.info("onError -> {}",e);								
			}

			@Override
			public void onComplete() {
				logger.info("onComplete");								
			}

			
		});
		
		RXUtils.sleep(10000l);
	}
	
	
}
