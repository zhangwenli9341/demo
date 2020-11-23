package com.zhang.createThread;

public class ThreadTest {
    public static void main(String[] args) {
        //线程的创建是通过线程类来构造线程实例
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread  = new Thread(threadDemo);
        //启动线程,线程进入可运行状态，等待CPU分配时间片，分配之后执行run()方法
        thread.start();
    }
}

/**
 * 创建线程的类继承Thread类
 * 覆盖父类中的run方法
 */
class ThreadDemo extends Thread{
    //run方法是线程的执行体，线程需要执行的操作
    @Override
    public void run() {
        System.out.println("线程:"+Thread.currentThread().getName()+"执行");
    }
}