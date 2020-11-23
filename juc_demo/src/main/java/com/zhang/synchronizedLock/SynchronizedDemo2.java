package com.zhang.synchronizedLock;


public class SynchronizedDemo2 {
    Object object = new Object();

    public void method1() {
        synchronized (object) {

        }
    }
}
