package com.zhang.notify;

/**
 * sleep()和wait()的区别：sleep()不会释放锁，wait()会释放锁
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        CreateThread createThread = new CreateThread();
        createThread.test();
    }
}
