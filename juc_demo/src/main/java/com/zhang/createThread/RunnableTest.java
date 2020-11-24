package com.zhang.createThread;

/**
 * 通过实现Runnable接口来实现线程的创建
 */
public class RunnableTest {
    public static void main(String[] args) {
    RunnableImpl runnable = new RunnableImpl();
    //通过RunnableImpl实例来创建线程
    Thread thread = new Thread(runnable);
    //启动线程
        thread.start();
    }
}
/**
 * 实现Runnable接口必须实现run方法
 */
class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println("我是通过实现Runnable接口来创建的线程"+Thread.currentThread().getName());
    }
}