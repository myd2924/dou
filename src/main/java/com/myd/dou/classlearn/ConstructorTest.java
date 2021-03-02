package com.myd.dou.classlearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/20 09:35
 * @Description:
 */
public class ConstructorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = null;
        clazz = Class.forName("com.myd.dou.classlearn.Dog");

        Dog dog = (Dog)clazz.newInstance();
        System.out.println(dog);
        dog.setAge(2);
        dog.setName("小花");
        System.out.println(dog);

        System.out.println("-------------------");

        Constructor<?> constructor = clazz.getConstructor(String.class);
        Dog 小黑 = (Dog)constructor.newInstance("小黑");
        小黑.setAge(3);

        System.out.println(小黑);
        System.out.println("--------------------");

        Constructor<?> constructor1 = clazz.getDeclaredConstructor(String.class, int.class);
        constructor1.setAccessible(true);
        Dog 小灰 = (Dog)constructor1.newInstance("小灰", 6);
        System.out.println(小灰);
        System.out.println("--------------------");

        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        for(int i=0;i<cons.length;i++){
            Class<?>[] parameterTypes = cons[i].getParameterTypes();
            System.out.println("构造函数："+cons[i].toString());
            System.out.print("参数类型：(");
            for (int j=0;j<parameterTypes.length;j++){
                if(j == parameterTypes.length-1){
                    System.out.print(parameterTypes[j].getSimpleName());
                } else {
                    System.out.print(parameterTypes[j].getSimpleName() + ",");
                }
            }
            System.out.println(")");
        }

        System.out.println("-------fields------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int k=0;k<declaredFields.length;k++){
            System.out.println(declaredFields[k].getName());
        }

        System.out.println("-------methods------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int n=0;n<declaredMethods.length;n++){
            System.out.println(declaredMethods[n].getName());
        }

        Method print = clazz.getMethod("print", String.class);
        print.invoke(小黑,小黑.getName()+" 我的名字叫小黑");

    }
}

