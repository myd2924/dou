package com.myd.dou.proxy;

/**
 * @ClassName Client
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 17:18
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        IUserManager userManager = (IUserManager)cglibProxy.creatProxyObject(new UserManagerImpl());
        userManager.addUser("cg","123");

        JdkProxy jdkProxy = new JdkProxy();
        IUserManager IUserManagerJdk = (IUserManager)jdkProxy.newProxy(new UserManagerImpl());
        IUserManagerJdk.addUser("jdk","456");

    }
}
