package com.myd.dou.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxy
 * @Description
 * @Author 18050909
 * @Date 2020/6/5 16:54
 * @Version 1.0
 **/
public class JdkProxy implements InvocationHandler{
    /**需要代理的目标对象*/
    private Object targetObject;

    /**
     * @Author 18050909
     * @Description  将目标对象传入进行代理
     * @Date 2020/6/5 16:59
     * @return java.lang.Object
     **/
    public Object newProxy(Object targetObject){
        this.targetObject = targetObject;
        /**返回代理对象*/
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),
                this);
    }

    /**
     * invoke方法
     **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
        checkPopedom();
        // 设置方法的返回值
        Object ret = null;
        // 调用invoke方法，ret存储该方法的返回值
        ret = method.invoke(targetObject,args);
        return ret;
    }

    /**
     * 模拟检查权限的例子
     */
    private void checkPopedom() {
        System.out.println("======jdk检查权限checkPopedom()======");
    }
}

