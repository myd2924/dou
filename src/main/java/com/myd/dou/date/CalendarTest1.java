package com.myd.dou.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/24 17:49
 * @Description:
 */
public class CalendarTest1{
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        String string = "2021-06-24 14:38:49";

        String date = "2021-06-24T14:38:49.0+08";
        final Date date1 = DateUtils.dealDateFormat(date);
        System.out.println(date1);
    }
}
