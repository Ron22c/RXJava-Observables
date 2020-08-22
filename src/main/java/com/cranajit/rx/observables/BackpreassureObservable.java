package com.cranajit.rx.observables;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Flowable;

public class BackpreassureObservable {

	private static Integer counter = 1;
	private static Subscription sub;

	public static void main(String... args) {
		Logger log = LoggerFactory.getLogger(BackpreassureObservable.class);

		Flowable.fromIterable(RXUtils.primeNumbers(100)).subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				sub = s;
				log.info("onSubscribe: {}", s);
				s.request(5);
			}

			@Override
			public void onNext(Integer t) {
				log.info("onNext: {}", t);
				counter++;
				if (counter % 5 == 0) {
					System.out.println("fetching more data");
					sub.request(5);
				}
			}

			@Override
			public void onError(Throwable t) {
				log.info("onError: {}", t);
			}

			@Override
			public void onComplete() {
				log.info("onComplete");
			}
		});
	}
}
