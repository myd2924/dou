package com.myd.dou.date;

import com.myd.dou.util.DateUtils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/24 17:49
 * @Description:
 */
public class CalendarTest1{
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime time = DateUtils.asLocalDateTime(date);
        System.out.println(time);

        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        final Date date1 = DateUtils.asDate(now);
        System.out.println(date1);

        final Optional<Date> empty = Optional.empty();
    }
}
