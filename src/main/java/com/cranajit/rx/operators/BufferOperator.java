package com.cranajit.rx.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class BufferOperator {
	Logger logger = LoggerFactory.getLogger(BufferOperator.class);
	public static void main(String... args) {
		Observable.fromIterable(RXUtils.shapes(10))
		.buffer(4).subscribe(new DemoObserver());
	}
}
