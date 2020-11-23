package com.zhang.Volatile;

/**
 * 为什么需要在变量前面加volatile关键字,首先我们需要了解对象的构造过程。
 * 对象实例化一共分为三个步骤：
 * 1、分配内存空间
 * 2、初始化对象
 * 3、将内存空间的地址赋值给对应的引用
 * 但是由于操作系统可以对指令进行重排序，所以上面的过程可能会变成如下过程：
 * 1、分配内存空间
 * 2、将内存空间的地址赋值给对应的引用
 * 3、初始化对象
 *如果是上面这种情况，多线程环境下就可能将未初始化的对象引用暴露出来，从而导致不可预料的结果。
 * 因此，为了防止这个过程的重排序，我们需要将变量设置成volatile类型的变量
 *
 *实现可见性：
 * 可见性问题是指一个线程修改了共享变量值，而另一个线程却看不到。引起可见性问题的主要原因是每个线程都拥有自己的一个高速缓存区————线程工作内存。
 * volatile关键字可以有效的解决这个问题
 * volatile的实现原理:
 *
 */
public class VolatileDemo {
    int a = 1;
    int b = 2;
    public void change(){
        a = 3;
        b = a;
    }
    public void print(){
        System.out.println("b="+b+";"+"a="+a);
    }

    public static void main(String[] args) {
        while(true){
            final VolatileDemo volatileDemo = new VolatileDemo();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    volatileDemo.change();
                }
            }).start();
            new Thread(new Runnable(){

                @Override
                public void run() {
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    volatileDemo.print();
                }
            }).start();

        }
    }
}
