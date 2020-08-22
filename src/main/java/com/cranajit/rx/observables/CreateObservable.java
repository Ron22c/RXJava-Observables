package com.cranajit.rx.observables;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class CreateObservable {
	Logger log = LoggerFactory.getLogger(CreateObservable.class);
	
	public static void main(String[] args) {
		List<Shapes> shapes = RXUtils.shapes(6);
		Observable.create(new ObservableOnSubscribe<Object>() {

			@Override
			public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
				try {
					shapes.forEach(val -> {
						emitter.onNext(val);
					});
				} catch(Exception e) {
					emitter.onError(e);
				}
				emitter.onComplete();
			}
			
		}).subscribe(new DemoObserver());
	}
}
