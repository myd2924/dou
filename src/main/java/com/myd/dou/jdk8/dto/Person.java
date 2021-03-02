package com.myd.dou.jdk8.dto;


import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/7/23 14:34
 * @Created by mayd
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    /**姓名*/
    private String name;
    /**年纪*/
    private int age;
    /**id*/
    private String id;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
