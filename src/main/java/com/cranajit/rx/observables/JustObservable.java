package com.cranajit.rx.observables;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.observers.DemoObserver;

import io.reactivex.Observable;

public class JustObservable {
	public final static Logger logger = LoggerFactory.getLogger(JustObservable.class);
	
	public static void main(String[] args) {
		Observable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
				.subscribe(new DemoObserver());
		
		
	}
}
