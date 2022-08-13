package com.godoro.geometry;

public class Rectangle {
	
	private int width;

	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		if (width < 0) 
			throw new IllegalArgumentException("Genişlik negatif olamaz " );
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if (height < 0) 
			throw new IllegalArgumentException("Yükseklik negatif olamaz " );
		this.height = height;
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int getArea() {
		return width * height;
	}
	
	public int getPerimeter() {
		return 2 * (width + height);
	}
	
}
