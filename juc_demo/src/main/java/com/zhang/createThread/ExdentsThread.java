package com.zhang.createThread;

/**
 * 继承Thread类创建线程
 * java中只支持单继承
 * Thread方式不能返回线程执行结果
 */
public class ExdentsThread extends Thread{
    //线程执行过程
    @Override
    public void run() {
        DataUtils dataUtils = new DataUtils();
        dataUtils.getListData(Thread.currentThread().getName());
    }
}
