package com.dajia.java8;

import com.dajia.entity.Employee;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Consumer;

public class TestLambda2 {

    List<Employee> employeeList = Arrays.asList(
            new Employee("1", "张三", 20, 5555.55),
            new Employee("2", "李四", 37, 7777.77),
            new Employee("3", "王五", 39, 4444.44),
            new Employee("4", "赵六", 20, 8888.88),
            new Employee("5", "田七", 56, 9999.99)
    );

    @Test
    public void test5() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("today = " + today);
        System.out.println("lastDayOfMonth = " + lastDayOfMonth);
        System.out.println(Period.between(today, lastDayOfMonth).getDays() == 0); // true表示是最后一天，false表示不是最后一天
    }
    @Test
    public void test4() throws Exception {
        Employee employee = new Employee();
        employee.setAge(null);
        employee.setName("");
        employee.setId(null);
        employee.setArray(null);
        employee.setList(null);
        employee.setMap(null);

        System.out.println("isAllFieldNull  --> " + isAllFieldNull(employee));
        System.out.println("isAllFieldNull  --> " + isAllFieldNotNull(employee));
    }

    /**
     * 检查属性是否都不为空
     * 只要对象里有一个属性为空,返回false   否则返回true
     *
     * @param obj
     * @return
     */
    public static boolean isAllFieldNotNull(Object obj) throws Exception {
        if (obj == null) {
            return false;
        }
        // try {
        for (Field field : obj.getClass().getDeclaredFields()) {
            //把私有属性公有化
            field.setAccessible(true);
            Object val = field.get(obj);
            if (Objects.isNull(val) || "".equals(val.toString())) {
                return false;
            }
            // 集合和map 单独判断
            if (val instanceof Collection) {
                Collection colVal = (Collection) val;
                if (colVal.isEmpty()) {
                    return false;
                }
            }
            if (val instanceof Map) {
                Map mapVal = (Map) val;
                if (mapVal.isEmpty()) {
                    return false;
                }
            }

        }
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     return false;
        // }
        return true;
    }


    /**
     * 校验对象属性是否都为空
     *
     * @param obj 对象
     * @return
     * @throws Exception
     */
    public boolean isAllFieldNull(Object obj) throws Exception {
        if (obj == null) {
            return true;
        }
        //得到属性集合
        Field[] filedArray = obj.getClass().getDeclaredFields();
        for (Field field : filedArray) {
            // 设置属性是可以访问的(私有的也可以)
            field.setAccessible(true);
            // 得到此属性的值
            Object val = field.get(obj);
            if (val != null) {
                if ("".equals(val.toString())) {
                    return true;
                }
                if (val instanceof Collection) {
                    Collection colVal = (Collection) val;
                    if (!colVal.isEmpty()) {
                        return false;
                    }
                }
                if (val instanceof Map) {
                    Map mapVal = (Map) val;
                    if (!mapVal.isEmpty()) {
                        return false;
                    }
                }
                //只要有1个属性不为空,那么就不是所有的属性值都为空
                return false;
            }

        }
        return true;
    }


    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("进行比较");
            return Integer.compare(x, y);
        };
        int compare = com.compare(1, 1);
        System.out.println(compare);
    }

    /**
     * 有一个参数  没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("abcde");
    }

    /**
     * 没有参数 没有返回值
     */
    @Test
    public void test1() {
        Runnable r1 = () -> System.out.println("Hello labmda");
        r1.run();
    }


}
