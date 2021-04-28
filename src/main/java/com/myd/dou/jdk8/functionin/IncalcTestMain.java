package com.myd.dou.jdk8.functionin;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:36
 * @Description: 定义一种形式，具体实现随便玩
 */
public class IncalcTestMain {

    static void product(int a,int b,InCalc calc){
        Object result = calc.calc(a,b);
        System.out.println(result);

    }
    public static void main(String[] args) {
        product(2,3,(x,y)->x*y);
        product(2,3,(x,y)->x+y);
        product(2,3,(x,y)->" "+x+" "+y);
    }
}
