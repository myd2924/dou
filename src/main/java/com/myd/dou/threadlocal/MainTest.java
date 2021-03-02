package com.myd.dou.threadlocal;

import java.util.concurrent.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/19 16:02
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(5,10,100L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2000), new ThreadPoolExecutor.AbortPolicy());

        for (int i=0;i<10;i++){
            int num = i;
            executorService.execute(()->{
                System.out.println(num + " " + NumUtil2.add10(num) );
                System.out.println(num + " local " + NumUtil2.add10Local(num) );
                NumUtil2.remove();
            });
        }


        executorService.shutdown();
    }



}
