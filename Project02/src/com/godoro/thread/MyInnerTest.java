package com.godoro.thread;

public class MyInnerTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                walk();
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();
        proccess();
    }
    private static void walk() {
        while (true) {
            try {
                System.out.println("KOŞUYOR....");
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static void proccess() {
        while (true) {
            try {
                System.out.println("SURUYOR....");
                Thread.sleep(750);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
