package com.zhang.synchronizedLock;

/**
 * Synchronized修饰普通方法，默认锁对象为this
 */
public class SynchronizedMethod implements Runnable{
    static SynchronizedMethod instance = new SynchronizedMethod();
    @Override
    public void run() {
        method();
    }
    public synchronized void method(){
        System.out.println("我是线程"+Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
