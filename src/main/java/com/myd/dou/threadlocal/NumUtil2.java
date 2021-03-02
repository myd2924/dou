package com.myd.dou.threadlocal;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/19 15:25
 * @Description:
 */
public class NumUtil2 {

    /**
     * ThreadLocal 高并发情况下使用
     */
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    private static int addNum = 0;

    public static int add10(int num){
        addNum = num;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum+10;
    }

    public static Integer add10Local(Integer num){
        local.set(num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return local.get()+10;
    }

    public static void remove(){
        local.remove();
    }

}
