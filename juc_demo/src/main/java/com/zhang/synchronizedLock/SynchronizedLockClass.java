package com.zhang.synchronizedLock;

/**
 * Synchronized锁类
 */
public class SynchronizedLockClass implements Runnable{
    static SynchronizedLockClass instance1 = new SynchronizedLockClass();
    static SynchronizedLockClass instance2 = new SynchronizedLockClass();
    @Override
    public void run() {
        synchronized (SynchronizedLockClass.class){
            System.out.println("我是线程"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"结束");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}
