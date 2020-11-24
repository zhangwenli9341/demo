package com.zhang.createThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 实现Callable接口来创建线程
 * Callable有两种使用方式：
 * 1、配合Thread类来完成线程的创建
 * 2、搭配ExecutorService提供的线程池来创建线程
 *
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //第一种方式：配合Thread类来完成线程的创建
//        CallableImpl callable = new CallableImpl();
//        //通过CallableImpl类来构建FutureTask对象
//        FutureTask futureTask = new FutureTask(callable);
//        //创建线程实例
//        Thread thread = new Thread(futureTask);
//        //开启线程
//        thread.start();
//        //通过FutureTask中的get方法获取线程的执行结果，循环打印输出
//        List<Integer> list = (List<Integer>) futureTask.get();
//        for(Integer o:list){
//            System.out.println(o+"---"+thread.currentThread().getName());
//        }
        //第二种方式：通过搭配ExecutorService来创建线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableImpl callable = new CallableImpl();
        Future<List<Integer>> future = executorService.submit(callable);
        executorService.shutdown();
        List<Integer> list = future.get();
        for (Integer o:list){
            System.out.println(o);
        }



    }
}

/**
 * 定义一个线程类
 */
class CallableImpl implements Callable {

    //call方法是线程的执行体，并且附带返回值
    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList(16);
        for(int i=0; i<10; i++){
            list.add(new Random().nextInt(10));
        }
        return list;
    }
}
