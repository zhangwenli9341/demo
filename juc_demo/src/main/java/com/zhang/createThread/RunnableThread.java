package com.zhang.createThread;

/**
 * 实现Runnable接口创建线程
 * 接口可以有多个实现，易于程序扩展
 */
public class RunnableThread implements Runnable{
    //线程执行过程，无返回值
    public void run() {
        DataUtils dataUtils = new DataUtils();
        dataUtils.getListData(Thread.currentThread().getName());
    }
}
