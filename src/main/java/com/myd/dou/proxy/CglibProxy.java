package com.myd.dou.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 16:54
 * @Version 1.0
 **/
public class CglibProxy implements MethodInterceptor{

    /** CGLib需要代理的目标对象 */
    private Object targetObject;

    public Object creatProxyObject(Object obj){
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj  = enhancer.create();
        return proxyObj ;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        //过滤方法
        if("addUser".equals(method.getName())){
            checkPopedom();
        }
        obj = method.invoke(targetObject,objects);
        return obj;
    }

    private void checkPopedom() {
        System.out.println("======cglib检查权限checkPopedom()======");
    }

}
