package com.dajia.java8;

import com.dajia.entity.Employee;
import com.dajia.entity.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


/**
 * 终止操作
 * <p>
 * 查找与匹配
 * allMatch——检查是否匹配所有元素
 * anyMatch——检查是否至少匹配一个元素
 * noneMatch——检查是否没有匹配所有元素
 * findFirst——返回第一个元素
 * findAny——返回当前流中的任意元素
 * count——返回流中元素的总个数
 * max——返回流中最大值
 * min——返回流中最小值
 * <p>
 * <p>
 * <p>
 * 归约
 * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
 */
public class TestStreamAPI3 {


    List<Employee> employees = Arrays.asList(
            new Employee("1", "张三", 18, 9999.99, Status.FREE),
            new Employee("2", "李四", 58, 5555.55, Status.BUSY),
            new Employee("3", "王五", 26, 3333.33, Status.VOCATION),
            new Employee("4", "赵六", 36, 6666.66, Status.FREE),
            new Employee("5", "田七", 12, 8888.88, Status.FREE),
            new Employee("5", "田七", 12, 8888.88, Status.FREE)
    );

    @Test
    public void test11() {
        List<String> all = Arrays.asList("514748", "514797", "514745", "514718", "514783", "514733", "514726", "514850", "540026", "539444", "542518", "514749", "560971", "000167", "557013", "561597", "562463", "515097", "510322", "562414", "510353", "510572", "510664", "510766", "510412", "563939", "510536", "510049", "510651", "510565", "510610", "510210", "518926", "514776", "514780", "103199", "515365", "562306", "565392", "560861", "510536", "511105", "511843", "510398", "510406", "511824", "567266", "567029", "562591", "555922", "567005", "553447", "511591", "562263", "201198", "562265", "562260", "563051", "563050", "563952", "552641", "566834", "563942", "566303", "565131", "565854", "554158", "565775", "552735", "565389", "552632", "567646", "552741", "510297", "550412", "670356", "513276", "567054", "563611", "564284", "510706", "561697", "511785", "511900", "543087", "548528", "563027", "566925", "560147", "558966", "558606", "560526", "564255", "565356", "566935", "558225", "562623", "558578", "566390", "562276", "562905", "556536", "563756", "563235", "559371", "563112", "557309", "566569", "548836", "549578", "515377", "515378", "516689", "519047", "514771", "514770", "516088");
        List<String> sonList = Arrays.asList("514745", "563027", "514718", "549578", "562276", "562905", "559371", "563112", "557309", "565392", "542518", "518926", "514850", "552632", "510565", "510651", "552641", "563756", "510353", "555922", "514733", "510322", "510297", "562414", "510706", "510536", "563952", "563942", "515365", "550412", "563050", "510610", "510572", "513276", "563611", "514776", "510049", "552735", "510664", "562263", "562265", "552741", "553447", "565131", "201198", "562260", "510766", "540026", "563235", "514749", "510398", "511824", "510406", "510412", "564284", "562306", "562591", "511900", "543087", "563939", "514797", "511591", "563051", "560861", "561697", "564255", "514771", "516689", "514770", "515378", "515377", "511843", "560526", "560147", "558606", "511105", "511785", "558966", "554158", "515097", "516088", "519047", "103199", "558225", "514748", "514783", "558578", "562623", "000167", "548528", "560971", "556536", "510210", "539444", "514726", "548836", "565356", "566390", "562463", "557013", "561597", "565389", "565854", "565775", "566303", "514780");

        List<String> res = new ArrayList<>();
        for (String item : all) {
            if (!sonList.contains(item)) {
                res.add(item);
            }
        }
        // 差集
        System.out.println(res);

        System.out.println("之前总的个数: " + all.size());
        System.out.println("之前总的个数: " + sonList.size());

        List<String> distinctAllSize = all.stream().distinct().collect(Collectors.toList());
        List<String> distinctSonSize = sonList.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后总的个数: " + distinctAllSize.size());
        System.out.println("去重后字的个数:" + distinctSonSize.size());

        // 查找总的里面重复数据
        Set<String> set = new HashSet<>();
        for (String item : all) {
            if (!set.contains(item)) {
                set.add(item);
            } else {
                System.out.println("重复数据为: " + item);
            }
        }
    }

    @Test
    public void test10() {
        // 当key重复时,会报Duplicate key 的错,
        Map<String, Employee> collect = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(collect);
    }


    @Test
    public void test9() {
        // 根据对象的某个属性进行去重
        List<Employee> collect = employees.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(item -> item.getId()))), ArrayList::new));
        collect.stream().forEach(System.out::println);
    }


    @Test
    public void test8() {
        String collect = employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test7() {

        DoubleSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        double sum = collect.getSum();
        long count = collect.getCount();
        double average = collect.getAverage();
        double max = collect.getMax();
        double min = collect.getMin();

        System.out.println(sum);
        System.out.println(count);
        System.out.println(average);
        System.out.println(max);
        System.out.println(min);


    }

    @Test
    public void test6() {
        Map<Status, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        collect.keySet().forEach(item -> System.out.println(collect.get(item)));

        System.out.println("---------------------");
        Map<Status, Map<String, List<Employee>>> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                    if (e.getAge() <= 30) {
                        return "青年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(collect1);
    }

    @Test
    public void test5() {
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("-------------------------");

        Double average = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(average);

        System.out.println("-------------------------");

        Optional<Employee> maxSalary = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(maxSalary.get());

        System.out.println("------------------------");

        Optional<Employee> minAge = employees.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(minAge.get());

        System.out.println("------------------------");

        Optional<Double> minSalary2 = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(minSalary2.get());


    }




    @Test
    public void test4() {
        List<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("----------------------");

        Set<String> set = employees.stream().map(employee -> employee.getName())
                .collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("----------------------");

        List<Double> list3 = employees.stream().map(Employee::getSalary)
                .filter((e) -> e > 6000)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list3);

        System.out.println("--------------------");

        HashSet<Employee> collect1 = employees.stream()
                .collect(toCollection(HashSet::new));
        collect1.forEach(System.out::println);


    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("-----------------------");

        Optional<Double> optional = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .reduce(Double::sum);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }


    @Test
    public void test2() {
        long count = employees.stream().count();
        System.out.println(count);

        System.out.println("--------------------");

        Optional<Employee> optional1 = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        if (optional1.isPresent()) {
            System.out.println(optional1.get());
        }

        System.out.println("----------------");
        Optional<Employee> min = employees.stream()
                .filter((e) -> Status.BUSY.equals(e.getStatus()))
                .min(Comparator.comparingInt(Employee::getAge));
        if (min.isPresent()) {
            System.out.println(min.get());
        }
    }

    @Test
    public void test1111() {
        ArrayList<String> a = new ArrayList<>();
        // a.add("1");
        // a.add("2");
        // a.add("3");
        List<String> b = new ArrayList<>();
        b.add("2");
        b.add("3");
        b.add("4");


        boolean flag = b.containsAll(a);
        System.out.println(flag);


        b.removeAll(a);
        System.out.println(b);


    }


    @Test
    public void test1() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        System.out.println("-----------------");

        boolean b2 = employees.stream()
                .anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);

        System.out.println("-----------------");

        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b3);

        System.out.println("-----------------");

        Optional<Employee> first = employees.stream()
                .filter((e) -> e.getAge() > 30)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }

        System.out.println("-----------------");
        Optional<Employee> any = employees.stream()
                .filter(e -> e.getSalary() > 66000)
                .findAny();
        System.out.println(any);
        if (any.isPresent()) {
            System.out.println(any.get());
        }
        System.out.println("1111");
    }


}
