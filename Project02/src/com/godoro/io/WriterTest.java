package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterTest {

	public static void main(String[] args) throws Exception{
		
		String path = "C:\\Users\\Sabri\\Desktop\\workspace\\out.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.write("Java\r\n");
		bw.write("JDB\r\n");
		bw.write("Java\r\n");
		bw.write("Java\r\n");
		bw.write("Java\r\n");
		bw.close();
	}

}
