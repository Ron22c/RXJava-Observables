package com.cranajit.rx.model;

public class Shapes {
	private String shape;
	private String color;
	public Shapes(String shape, String color) {
		super();
		this.shape = shape;
		this.color = color;
	}
	public Shapes() {
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Shapes [shape=" + shape + ", color=" + color + "]";
	}
}
