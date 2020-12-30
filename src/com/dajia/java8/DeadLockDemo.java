package com.dajia.java8;

import java.util.Random;

/**
 * Program Name: java8
 * Created by yanlp on 2020-12-09
 *
 * @author yanlp
 * @version 1.0
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        while (true) {
            System.out.println(new Random().nextInt(10000));
        }
    }
}