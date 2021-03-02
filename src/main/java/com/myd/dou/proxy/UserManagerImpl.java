package com.myd.dou.proxy;

/**
 * @ClassName UserManagerImpl
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 16:56
 * @Version 1.0
 **/
public class UserManagerImpl implements IUserManager{
    @Override
    public void addUser(String id, String psw) {
        System.out.println("======调用了UserManagerImpl.addUser()方法======");
    }
}
