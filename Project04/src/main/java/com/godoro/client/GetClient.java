package com.godoro.client;

import static com.godoro.utils.StreamUtilities.*;

public class GetClient {
	public static void main(String[] args) throws Exception {
		String adress = "http://localhost:12713/Project04/get";
		String text = get(adress);
		System.out.println("İçerik: \r\n" + text);
	}
}
