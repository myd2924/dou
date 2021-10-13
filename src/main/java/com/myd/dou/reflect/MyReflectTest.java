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
        newInstance.setAge(30);

        final String class_name = "com.myd.dou.reflect.MyReflect";//可配置
        final Class<?> aClass = Class.forName(class_name);
        final MyReflect instance = (MyReflect)aClass.newInstance();
        instance.setName("woca");

        MyReflect myReflect = new MyReflect("myd",5,"dancing");
        for (Method m : declaredMethods){

            if("puMethod".equals(m.getName())){
                final Object daxi = m.invoke(newInstance, "daxi");
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
                continue;
            }

            if("staticMethod".equals(m.getName())){//静态方法可省略对象，直接用null替代，或用clas
                final Object 我是静态 = m.invoke(null, "我是静态");
                System.out.println(我是静态);
            }

        }

    }
}
