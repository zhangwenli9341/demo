package com.zhang.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThread {
    private class RunnableThread implements Runnable{

        public void run() {
            WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
            waitNotifyExample.after();
            waitNotifyExample.before();
        }
    }
    private class CreateThreadByExecutor{
        public void createThread(){
            ExecutorService executorService = Executors.newCachedThreadPool();
            final WaitNotifyExample example = new WaitNotifyExample();
            executorService.execute(()->example.before());
            executorService.execute(()->example.after());
            executorService.shutdown();
        }
    }
    public void test(){
        CreateThreadByExecutor  createThreadByExecutor = new CreateThreadByExecutor();
        createThreadByExecutor.createThread();
    }
}
