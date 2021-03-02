package com.myd.dou.jvm;

/**
 * @ClassName SingletTest
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/20 16:48
 * @Version 1.0
 **/
public class SingletTest {
        private static SingletTest instance = new SingletTest();
        private static int count1;
        private static int count2 = 0;
        private int count3;
        private SingletTest() {
            System.out.println("构造函数");
            count1++;
            count2++;
            System.out.println("count2="+count2);
        }
        static {
            System.out.println("静态代码块");
        }
        {
            count3++;
            System.out.println("非静态代码块");
        }
        public static SingletTest getInstance() {
            return instance;
        }
        public static void main(String[] args) {
            SingletTest instance = SingletTest.getInstance();
            System.out.println("主函数代码块");
            System.out.println("count1=" + count1);
            System.out.println("count2=" + count2);
            System.out.println("count3=" + instance.count3);
        }
}
