package com.dajia.java8;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Program Name: java8
 * Created by yanlp on 2020-05-04
 *
 * @author yanlp
 * @version 1.0
 */
class ColdDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BumThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000*3);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class MapTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        long start = System.currentTimeMillis();
//
//        // 等凉菜
//        Callable ca1 = new Callable() {
//
//            @Override
//            public String call() throws Exception {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "凉菜准备完毕";
//            }
//        };
//        FutureTask<String> ft1 = new FutureTask<String>(ca1);
//        new Thread(ft1).start();
//
//        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
//        Callable ca2 = new Callable() {
//
//            @Override
//            public Object call() throws Exception {
//                try {
//                    Thread.sleep(1000 * 3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "包子准备完毕";
//            }
//        };
//        FutureTask<String> ft2 = new FutureTask<String>(ca2);
//        new Thread(ft2).start();
//
//        System.out.println(ft1.get());
//        System.out.println(ft2.get());
//
//        long end = System.currentTimeMillis();
//        System.out.println("准备完毕时间：" + (end - start));

        long start = System.currentTimeMillis();

        // 等凉菜 -- 必须要等待返回的结果，所以要调用join方法
        Thread t1 = new ColdDishThread();
        t1.start();
        t1.join();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Thread t2 = new BumThread();
        t2.start();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));

    }
    @Test
    public void test3() {
        BigDecimal bigDecimal = new BigDecimal("0.00");
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO) > 0);
    }


    @Test
    public void test2() {
        Map<String, Object> map2 = new HashMap<>();
        map2.put("k111","v1");
        map2.put("k222","v2");
        map2.put("k111","v3");
        map2.put("k111","v4");
        map2.put("k111","v5");
        map2.put("k111","v6");
        map2.put("k111","v7");
        map2.put("k111","v8");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        map2.put("k111","v9");
        for (Object s : map2.values()) {
            System.out.println(s);
        }
    }
}
