package com.godoro.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> provinceList = new ArrayList<String>();
		provinceList.add("ankara");
		provinceList.add("istanbul");
		provinceList.add("izmir");
		for(String province: provinceList) {
			System.out.println("- "+ province);
		}
	}

}
