package com.godoro.thread;

public class MyThreadTest {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        while(true) {
            try {
                System.out.println("SURUYOR....");
                Thread.sleep(750);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
