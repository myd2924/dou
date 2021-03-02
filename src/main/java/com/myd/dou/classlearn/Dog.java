package com.myd.dou.classlearn;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/19 18:02
 * @Description:
 */
@Data
public class Dog implements Animal {

    private String name;

    private int age;

    public Dog(){}

    public Dog(String name){
        this.name = name;
    }

    private Dog(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void print(String name){
        System.out.println("打印名称："+name);
    }


}
