package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TryTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\Sabri\\Desktop\\workspace\\out.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write("Java\r\n");
            bw.write("JDB\r\n");
            bw.write("Java\r\n");
            bw.write("Java\r\n");
            bw.write("Java\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
