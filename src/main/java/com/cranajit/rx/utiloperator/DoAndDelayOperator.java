package com.cranajit.rx.utiloperator;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class DoAndDelayOperator {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(DoAndDelayOperator.class);
		Observable.fromIterable(RXUtils.postiveNumbers(8))
			.delay(2,TimeUnit.SECONDS)
			.subscribe(new DemoObserver());
			
		RXUtils.sleep(10000l);
		
		Observable.fromIterable(RXUtils.shapes(5))
		.doOnSubscribe(onSubscribe->{
			logger.info("doOnSubscribe-> {}", onSubscribe);
		})
		.doOnEach(onNotification-> {
			logger.info("onNotification-> {}", onNotification.getValue());
		})
		.doOnNext(onNext-> {
			logger.info("onNext-> {}", onNext);
		})
		.doOnComplete(()-> {
			logger.info("onComplete-> ");
		})
		.subscribe(new DemoObserver());
	}
}
