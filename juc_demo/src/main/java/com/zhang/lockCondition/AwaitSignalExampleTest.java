package com.zhang.lockCondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AwaitSignalExampleTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        executorService.execute(()->awaitSignalExample.after());
        executorService.execute(()->awaitSignalExample.before());
    }
}
