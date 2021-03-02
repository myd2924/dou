package com.myd.dou.jdk8.jdk8stream;

import com.myd.dou.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EightStream {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("daxi","nanjing",4,"study");
        Student stu2 = new Student("erxi","suzhou",2,"study2");
        Student stu3 = new Student("sanxi","beijing",3,"study3");
        Student stu4 = new Student("sixi","shanghai",6,"study4");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);

        Stream<Student> stream = list.stream();
        //过滤年纪大于3岁的集合
        List<Student> collect = stream.filter(s -> s.getAge() > 3).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(collect1);


    }
}
