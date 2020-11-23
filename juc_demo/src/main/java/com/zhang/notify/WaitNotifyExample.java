package com.zhang.notify;

public class WaitNotifyExample {
    public synchronized void after(){
        System.out.println("after");
        notifyAll();
    }

    public synchronized void before(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before");
    }
}
