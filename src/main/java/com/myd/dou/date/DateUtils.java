package com.myd.dou.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/22 17:28
 * @Description: TODO
 */
public class DateUtils {

    public static Date dealDateFormat(String oldDateStr) {
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date  date = df.parse(oldDateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
