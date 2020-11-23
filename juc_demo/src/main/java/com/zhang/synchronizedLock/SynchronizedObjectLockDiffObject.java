package com.zhang.synchronizedLock;

/**
 * 线程使用的不是同一把锁，后续线程可以继续执行
 */
public class SynchronizedObjectLockDiffObject implements Runnable{
    static SynchronizedObjectLockDiffObject instance = new SynchronizedObjectLockDiffObject();
    //创建两把锁
    Object block1 = new Object();
    Object block2 = new Object();
    @Override
    public void run() {
        //分别使用两个锁锁住不同的代码块
        synchronized (block1){
            System.out.println("block1锁，我是线程"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("block1锁,"+Thread.currentThread().getName()+"结束");
        }
        synchronized (block2){
            System.out.println("blcok2锁，我是线程"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("blcok2锁，"+Thread.currentThread().getName()+"结束");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
