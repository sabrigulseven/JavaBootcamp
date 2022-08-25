package com.godoro.geometry;

public class CircleTest {
	
	public static void main(String[] args) {
	
		Circle circle = new Circle(3);
		System.out.printf("A= " + "%2.2f %n", circle.getArea());
		System.out.printf("P= " + "%2.2f %n",circle.getPerimeter());
		
	}
}
