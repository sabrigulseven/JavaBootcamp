package com.godoro.collections;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int[4];
		array[0] = 3;
		array[1] = -7;
		array[2] = 11;
		array[3] = 6;
		
		int product = 1;
		for (int i : array) {
			product = product * i;
		}
		
		System.out.println("Çarpım: " + product);
	}
	
}
