package com.godoro.thread;

public class MyLambdaTest {
    public static void main(String[] args) {
        // Runnable runnable = () -> walk();
        // Thread thread = new Thread(runnable);
        // thread.start();

        // Thread thread2 = new Thread(() -> walk());
        // thread2.start();

        new Thread(() -> walk())
                .start();
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
