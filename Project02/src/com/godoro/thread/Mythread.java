package com.godoro.thread;

public class Mythread extends Thread{

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("KOŞUYOR....");
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
