package com.myd.dou.single;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/16 19:54
 * @Description: TODO
 */
public class EhanTest {
    private static EhanTest instance = new EhanTest();
    private EhanTest(){}
    public static EhanTest getIntance() {
        return instance;
    }
}
