package com.godoro.console;


public class BuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("Godoro: ");
		builder.append("HTML").append(", ");
		builder.append("HTML").append(", ");
		builder.append("HTML").append(", ");
		builder.append("HTML").append(", ");
		builder.append("HTML").append(", ");
		builder.append("HTML").append(". ");
		String string = builder.toString();
		System.out.println("Sicim: " + string);
		
		String string2 = new StringBuilder("Godoro: ")
				.append("HTML").append(", ")
				.append("HTML").append(", ")
				.append("HTML").append(", ")
				.append("HTML").append(", ")
				.append("HTML").append(". ")
				.toString();
		System.out.println("Sicim: " + string2);
			

	}
}
