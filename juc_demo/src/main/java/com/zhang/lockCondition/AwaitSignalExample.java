package com.zhang.lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent类库中提供了Condition类来实现线程之间的协调,可以在Condition上调用await()方法使线程进行等待，
 * 其他线程调用signal()、signalAll()方法唤醒等待的线程。相比wait()方式，await()可以指定等待的条件，更加灵活。
 */
public class AwaitSignalExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void after(){
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void before(){
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
