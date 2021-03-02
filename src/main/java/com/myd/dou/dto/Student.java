package com.myd.dou.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/14 11:54
 * @Version 1.0
 **/
public class Student implements Serializable{

    private static final long serialVersionUID = -3900077594643401743L;
    private String name;
    private String addr;
    private int age;
    private String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    public Student(String name, String addr, int age, String hobby) {
        this.name = name;
        this.addr = addr;
        this.age = age;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
