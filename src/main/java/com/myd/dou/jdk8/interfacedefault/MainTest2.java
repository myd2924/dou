package com.myd.dou.jdk8.interfacedefault;

import com.myd.dou.jdk8.dto.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/7/23 18:19
 * @Description: stream filter map
 */
public class MainTest2 {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream().filter((s)-> s.startsWith("a")).forEach(System.out::println);
        System.out.println("**************");
        //stringCollection.stream().sorted().filter((s)->s.startsWith("a")).forEach(System.out::println);
        stringCollection.stream().sorted().filter((s)->s.startsWith("a")).peek(s -> System.out.println(s)).forEach(System.out::println);

        List<Person> pList = new ArrayList<>();
        pList.add(Person.builder().age(2).name("aaa1").build());
        pList.add(Person.builder().age(3).name("bbb1").build());
        pList.add(Person.builder().age(4).name("ccc1").build());
        pList.add(Person.builder().age(5).name("aaa3").build());
        pList.add(Person.builder().age(6).name("aaa2").build());

        List<String> collect = pList.stream().map(Person::getName).map(String::toString).collect(Collectors.toList());
        System.out.println(collect);

    }
}
