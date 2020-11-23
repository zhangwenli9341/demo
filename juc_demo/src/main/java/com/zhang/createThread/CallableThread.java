package com.zhang.createThread;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口创建线程
 * 接口可以有多个实现，可以返回线程执行结果
 */
public class CallableThread implements Callable<String> {
    public String call() throws Exception {
        DataUtils dataUtils = new DataUtils();
        dataUtils.getListData(Thread.currentThread().getName());
        return Thread.currentThread().toString();
    }
}
