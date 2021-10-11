package com.myd.dou.reflect;

import com.myd.dou.dto.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description
 * @Author 18050909
 * @Date 2020/5/19 10:06
 * @Version 1.0
 **/
public class ReflectTest {
    public static final int N = 10000000;
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //normal();
        //reflectIns();

        User user = new User();
        System.out.println(user.getClass());
        System.out.println(user.getClass().getClassLoader());
        Class<? extends User> aClass = user.getClass();
        System.out.println("******fields*********");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i=0;i<declaredFields.length;i++){
            System.out.println(declaredFields[i].getName());
        }
        System.out.println("******method*******");
        Method[] methods = aClass.getMethods();
        for (int i=0;i<methods.length;i++){
            System.out.println(methods[i].getName());
        }

        Method doSomething = aClass.getMethod("doSomething");
        doSomething.invoke(user);


    }
    /**反射*/
    private static void reflectIns() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        long start = System.currentTimeMillis();
        Class<?> aClass = Class.forName("com.myd.dou.dto.User");
        for(int i=0;i<N;i++){
            User u = (User)aClass.newInstance();
            u.doSomething();
        }
        long end = System.currentTimeMillis();
        System.out.println("反射正常耗时："+(end-start));
    }
    /**正常*/
    private static void normal() {
        long start = System.currentTimeMillis();
        for(int i=0;i<N;i++){
            User u = new User();
            u.doSomething();
        }
        long end = System.currentTimeMillis();
        System.out.println("构造函数正常耗时："+(end-start));
    }
}
