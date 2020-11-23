package com.zhang.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Excetor线程池创建线程
 */
public class ExcutorThread {
    public static void createThread() throws InterruptedException {
        ExecutorService executorService =  Executors.newCachedThreadPool();
        RunnableThread runnableThread = new RunnableThread();
        executorService.execute(runnableThread);
        Thread.sleep(10000);
        System.out.println("等待结束");
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        createThread();
    }
}
