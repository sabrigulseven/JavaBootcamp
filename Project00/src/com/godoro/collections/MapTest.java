package com.godoro.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,String> countryMap = new HashMap<>();
		countryMap.put("tr", "Tr");
		countryMap.put("az", "AZ");
		countryMap.put("bg", "BG");
		countryMap.put("pl", "PLN");
		countryMap.put("pl", "2323");
		countryMap.remove("2323");
		for(String code: countryMap.keySet()) {
			String country = countryMap.get(code);
			System.out.println(code + ":" + country);
		}
	}
}
