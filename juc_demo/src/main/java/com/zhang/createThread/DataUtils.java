package com.zhang.createThread;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 公共类：提供数据供线程操作
 */
public class DataUtils {
    List<Integer> list = new ArrayList<Integer>(16);
    public void getListData(String threadName){
        synchronized (DataUtils.class) {
            for (int i = 0; i < 10; i++) {
                list.add(new Random().nextInt());
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(MessageFormat.format("我是{0}线程，这是list中第{1}个数据，%{2}", threadName, i, list.get(i)));
            }
        }
    }
}
