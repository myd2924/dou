package com.myd.dou.jdk8.lambda;

import com.myd.dou.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/1/18 11:07
 * @Description: 柯力化
 */
public class KeliHua {
    public static  <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三","张三",18));
        list.add(new Student("李四","李四",19));
        list.add(new Student("王五","王五",18));

        long count = list.stream().filter(distinctByKey(Student::getAge)).count();
        System.out.println(count);

        Map<Object,Boolean> seen = new ConcurrentHashMap<>();

        final Boolean aBoolean = seen.putIfAbsent("1", true);
        final Boolean bBoolean = seen.putIfAbsent("2", true);
        final Boolean cBoolean = seen.putIfAbsent("1", true);
        System.out.println("");
    }

}
