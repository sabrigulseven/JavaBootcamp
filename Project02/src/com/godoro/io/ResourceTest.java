package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ResourceTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\Sabri\\Desktop\\workspace\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { // auto closes
            bw.write("Java\r\n");
            bw.write("JDB\r\n");
            bw.write("Java\r\n");
            bw.write("Java\r\n");
            bw.write("Java\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
