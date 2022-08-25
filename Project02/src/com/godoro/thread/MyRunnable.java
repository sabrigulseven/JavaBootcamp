package com.godoro.thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
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
