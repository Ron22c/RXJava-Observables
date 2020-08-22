package com.cranajit.rx.filteroperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DebounceOperator {
	static Logger logger = LoggerFactory.getLogger(DebounceOperator.class);
	static List<Character> character = new ArrayList<Character>();
	public static void main(String[] args) {
		Random r = new Random();
		Observable.interval(2, TimeUnit.SECONDS)
		.map(element -> {
			character.add((char)(r.nextInt(26)+'a'));
			return character;
		})
		.doOnEach(nortification -> logger.info("current element -> {}", nortification.getValue()))
		.debounce(1, TimeUnit.SECONDS)
		.observeOn(Schedulers.newThread())
		.subscribeOn(Schedulers.newThread())
		.subscribe(new DemoObserver());
		RXUtils.sleep(10000l);
	}
}
