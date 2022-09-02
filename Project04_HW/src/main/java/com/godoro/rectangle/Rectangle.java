package com.godoro.rectangle;

public class Rectangle {

	private int height;
	private int width;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Rectangle() {
	}

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public int getArea() {
		int area = width * height;
		return area;
	}
	
	public int getPerimeter() {
		int perimeter = (width + height) * 2;
		return perimeter;
	}
}
