package com.myd.dou.jvm.four;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftRefer
 * @Description 软引用回收测试 演示失败
 * @Author 18050909
 * @Date 2020/5/22 10:26
 * @Version 1.0
 **/
public class SoftRefer {
    public static class User{
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }

    public static void main(String[] args) {
        User u = new User(4,"daxi");
        SoftReference<User> userSoftReference = new SoftReference<>(u);
        u = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("after gc");
        System.out.println(userSoftReference.get());

        byte[] b = new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftReference.get());

    }
}
