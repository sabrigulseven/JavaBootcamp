package com.godoro.thread;

public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread mythread = new Thread(myRunnable);
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
