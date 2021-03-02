package com.myd.dou.classlearn;

import com.myd.dou.dto.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/19 16:51
 * @Description: TODO
 */
public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        User user = new User("1","hH",5);
        User user2 = new User("2","GH",56);
        System.out.println(user.equals(user2));

        Class<? extends User> aClass = user.getClass();
        Class<? extends User> aClass1 = user2.getClass();
        System.out.println(aClass.equals(aClass1));

        ClassLoader classLoader = aClass.getClassLoader();
        Method method = aClass.getMethod("doSomething");
        Class<?>[] interfaces = aClass.getInterfaces();

        Method[] methods = aClass.getMethods();
        Annotation[] annotations = aClass.getAnnotations();
        Constructor<?>[] constructors = aClass.getConstructors();

        String simpleName = aClass.getSimpleName();
        String name = aClass.getName();
        Field declaredField = aClass.getDeclaredField("id");
        Field[] declaredFields = aClass.getDeclaredFields();

        Class<User> userClass = User.class;
        System.out.println(userClass.equals(aClass));
        User user1 = userClass.newInstance();


        //方式最好
        Class<?> clazz = Float.class;

        Class clazz1 = Integer.class;
        Class clazz2 = Double.class;

        //限定某一类
        Class<? extends Number> clazz3 = Integer.class;
        Dog dog = new Dog();

        Animal animal = dog;

        //instanceof 关键字
        if(dog instanceof Animal){
            Animal animal2 = dog;
        }

        //isInstance方法
        if(Animal.class.isInstance(dog)){
            Animal animal3= (Animal) dog;
        }



    }
}
