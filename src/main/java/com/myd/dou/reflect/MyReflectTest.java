package com.myd.dou.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/11 14:56
 * @Description:
 */
public class MyReflectTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        final Class<MyReflect> myReflectClass = MyReflect.class;
        final String className = myReflectClass.getName();
        System.out.println(className);
        final Class<?>[] interfaces = myReflectClass.getInterfaces();
        System.out.println(interfaces);
        final Field[] declaredFields = myReflectClass.getDeclaredFields();
        System.out.println(declaredFields);
        final Constructor<?>[] constructors = myReflectClass.getConstructors();
        System.out.println(constructors);
        final Method[] methods = myReflectClass.getMethods();
        System.out.println(methods);
        final Method[] declaredMethods = myReflectClass.getDeclaredMethods();

        final MyReflect newInstance = myReflectClass.newInstance();
        final Class<?> aClass = Class.forName("com.myd.dou.reflect.MyReflect");
        final MyReflect instance = (MyReflect)aClass.newInstance();

        MyReflect myReflect = new MyReflect("myd",5,"dancing");
        for (Method m : declaredMethods){

            if("puMethod".equals(m.getName())){
                final Object daxi = m.invoke(myReflect, "daxi");
                System.out.println(daxi);
                continue;
            }

            if("proMethod".equals(m.getName())){
                final Object daxi = m.invoke(myReflect, 20);
                System.out.println(daxi);
                continue;
            }

            if("priMethod".equals(m.getName())){
                m.setAccessible(true);
                final Object daxi = m.invoke(myReflect, "sing");
                System.out.println(daxi);
            }

        }

    }
}
