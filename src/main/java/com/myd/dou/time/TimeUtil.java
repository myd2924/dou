package com.myd.dou.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/29 14:25
 * @Description: TODO
 */
public class TimeUtil {
    public static void main(String[] args) {
        //time1();
       // time2();
        //time3();

        time4();
    }

    /**
     * 某个时间点 后的每天执行一次
     */
    private static void time4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,15);
        calendar.set(Calendar.MINUTE,7);
        calendar.set(Calendar.SECOND,0);
        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每天执行一次");
            }
        },time,1000*60*60*24);
    }

    /**
     * 定时任务 延迟2s  每2s执行一次
     */
    private static void time3() {
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每2s执行一次");
            }
        },2000,2000);
    }

    /**
     * 定时任务 延迟2s  每2s执行一次
     */
    private static void time2() {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每2s执行一次");
            }
        },2000,2000);
    }

    /**
     * 定时任务 延迟2s执行一次
     */
    private static void time1() {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务，延迟2s执行一次");
            }
        },2000);
    }


}
