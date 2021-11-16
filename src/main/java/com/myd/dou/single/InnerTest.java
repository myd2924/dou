package com.myd.dou.single;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/16 20:04
 * @Description: 内部类
 */
public class InnerTest {

    private InnerTest(){}

    private static class Holder{
        private static InnerTest instance = new InnerTest();
    }

    public static InnerTest getInstance(){
        return Holder.instance;
    }
}
