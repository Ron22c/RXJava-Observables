package com.cranajit.rx.filteroperator;

import java.util.List;

import com.cranajit.rx.model.Shapes;
import com.cranajit.rx.observers.DemoObserver;
import com.cranajit.rx.utils.RXUtils;

import io.reactivex.Observable;

public class FilterOperator {
	public static void main(String[] args) {
		List<Shapes> shapes = RXUtils.shapes(10);
		Observable.fromIterable(shapes)
				.filter(s -> s.getColor().equals("red"))
				.subscribe(new DemoObserver());
	}
}
