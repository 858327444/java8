package com.dajia.entity;

/**
 * Program Name: java8
 * Created by yanlp on 2020-11-25
 *
 * @author yanlp
 * @version 1.0
 */
public class Test {

    private int age;
    private Employee employee;

    private void changeValue1(int age) {
        age = 30;
    }

    private void changeValue2(Employee employee) {
        employee.setName("bbbbbb");
    }

    private void changeValue3(String str) {
        str = "3";
    }


    // public static void main(String[] args) {
    //     Test test = new Test();
    //
    //     int age = 20;
    //     test.changeValue1(age);
    //     System.out.println(age);
    //
    //     Employee employee = new Employee();
    //     employee.setName("1111");
    //     test.changeValue2(employee);
    //     System.out.println(employee.getName());
    //
    //
    //     String str = "abc";
    //     test.changeValue3(str);
    //     System.out.println(str);
    //
    //     int a = 1;
    //     method(a);
    //     // System.out.println(a++);
    //     System.out.println(a);
    // }

    private static int method(int a) {
        a++;
        return a;
    }

    public static void main(String[] args) {
        while (true) {
            Employee employee = new Employee();
        }
    }


}
