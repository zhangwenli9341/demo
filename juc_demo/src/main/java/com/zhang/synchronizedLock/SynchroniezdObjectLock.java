package com.zhang.synchronizedLock;

/**
 * jvm提供Synchronized关键字来对资源进行加锁操作
 * Synchronized关键字使用注意:
 * 1.一把锁只能同时被一个线程获取，没有获取到锁的线程只能等待。
 * 2.每个实例都对应自己的一把锁（this），不同实例之间互不影响。例外：锁对象是*.class以及Synchronized修饰的是static方法的时候，所有对象共用一把锁。
 * 3.Synchronized修饰的方法，无论方法正常执行结束还是抛出异常都会释放锁。
 */
public class SynchroniezdObjectLock implements Runnable{
    static SynchroniezdObjectLock instance = new SynchroniezdObjectLock();
    @Override
    public void run() {
        //对象锁
        //同步代码块形式-锁为this，两个线程使用的锁是一样的，线程1必须等到线程0释放锁之后才能执行
        synchronized (this){
            System.out.println("我是线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
