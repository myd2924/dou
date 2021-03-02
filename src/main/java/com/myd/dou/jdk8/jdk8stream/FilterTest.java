package com.myd.dou.jdk8.jdk8stream;

import com.myd.dou.jdk8.dto.Person;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/27 11:08
 * @Description: TODO
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Person> peoples = Arrays.asList(
                new Person("java", 22),
                new Person("js", 35),
                new Person("css", 31)
        );

        Person result1 = peoples.stream()
                .filter(p -> "java".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result1.getName());
    }
}
