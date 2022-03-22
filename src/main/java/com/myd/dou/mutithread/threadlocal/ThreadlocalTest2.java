package com.myd.dou.mutithread.threadlocal;

import com.myd.dou.dto.User;

/**
 * @ClassName ThreadlocalTest2
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 10:54
 * @Version 1.0
 **/
public class ThreadlocalTest2 {
    private static ThreadLocal<User> local = new ThreadLocal<>();
    private static Object object = new Object();

    public static User getUser(){
        if(null == local.get()){
            synchronized (object){
                if(null == local.get()){
                    local.set(new User());
                    return local.get();
                }else{
                    return local.get();
                }
            }
        }else{
            return local.get();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    User user = getUser();
                    System.out.println(user.hashCode());
                }
            }).start();
        }
    }
}
