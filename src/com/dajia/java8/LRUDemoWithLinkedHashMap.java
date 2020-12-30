package com.dajia.java8;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Program Name: java8
 * Created by yanlp on 2020-12-08
 *
 * @author yanlp
 * @version 1.0
 */
public class LRUDemoWithLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int capatity;

    public LRUDemoWithLinkedHashMap(int capatity) {
        super(capatity, 0.75F, true);
        this.capatity = capatity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capatity;
    }

    public static void main(String[] args) {
        LRUDemoWithLinkedHashMap<String, String> lruDemo = new LRUDemoWithLinkedHashMap<>(3);
        lruDemo.put("1","a");
        lruDemo.put("2","b");
        lruDemo.put("3","c");
        System.out.println(lruDemo.keySet());
        lruDemo.put("4","d");
        System.out.println(lruDemo.keySet());

        lruDemo.put("2","e");
        lruDemo.put("2","e");
        lruDemo.put("2","e");
        lruDemo.put("2","e");
        System.out.println(lruDemo.keySet());


    }
}
