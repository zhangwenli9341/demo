package com.zhang.createThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程创建
 */
public class ThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建ExtendsThread对象
        ExdentsThread exdentsThread = new ExdentsThread();
        //创建线程
        Thread t1 = new Thread(exdentsThread);
        //启动线程
        t1.start();
        //执行线程
        t1.run();

        //创建RunnableThread对象
        RunnableThread runnableThread = new RunnableThread();
        //创建线程实例
        Thread t2 = new Thread(runnableThread);
        //启动线程
        t2.start();
        //执行线程
        t2.run();

        //创建CallableThread对象
        CallableThread callableThread = new CallableThread();
        //创建FutureTask对象
        FutureTask futureTask = new FutureTask(callableThread);
        //通过FutureTask来创建线程
        Thread t3 = new Thread(futureTask);
        //启动线程
        t3.start();
        System.out.println(futureTask.get());
    }

}



