package com.myd.dou.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CommonUtil
 * @Description
 * @Author 18050909
 * @Date 2020/6/8 9:37
 * @Version 1.0
 **/
public class CommonUtil {

    public static final Integer NUM_ONE = 1;
    public static final int EIGHT_INT = 8;
    public static final int NINE_INT = 9;
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SHOW = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String NINE_ZERO = "000000000";
    public static final String TEN_ZERO = "0000000000";
    public static final String TWO_ZERO = "00";
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";



    private static final int EIGHTEEN = 18;

    private static final char ZERO_STRING = '0';

    private static ThreadLocal<SimpleDateFormat> dateFormatCacheHyphen = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };
    private static ThreadLocal<SimpleDateFormat> dateFormatCache_YYYYMMDDHHMMSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMMSS);
        }
    };

    private static ThreadLocal<SimpleDateFormat> dateFormatCache_YYYYMMDD = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        }
    };

    private static ThreadLocal<SimpleDateFormat> dateFormatCache_YYYYMM = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT_YYYYMM);
        }
    };

    private static ThreadLocal<SimpleDateFormat> dateFormatCache_show = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_SHOW);
        }
    };
    /**
     * @param sourceDate
     * @param compareDate
     * @return
     */
    public static int getMonthSpace(String sourceDate, String compareDate, String format) {
        try {
            int result = 0;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(sourceDate));
            c2.setTime(sdf.parse(compareDate));
            result = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 + c2.get(Calendar.MONTH)
                    - c1.get(Calendar.MONTH);
            return result == 0 ? 1 : Math.abs(result);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String formatTime(String time, String oldFormat, String newFormat) {
        String strTime = "";
        try {
            SimpleDateFormat sdf = getSimpleDateFormat(oldFormat);
            assert sdf != null;
            if (StringUtils.isNotBlank(time) && time.length() == 13) {
                Timestamp timestamp = new Timestamp(Long.parseLong(time));
                time = sdf.format(timestamp);
            }else if(CommonUtil.DATE_FORMAT_YYYYMMDDHHMMSS.equals(oldFormat) && time.length() != 14) {
                return strTime;
            }
            sdf.setLenient(false);
            Date date = sdf.parse(time);
            sdf = getSimpleDateFormat(newFormat);
            assert sdf != null;
            strTime = sdf.format(date);
        } catch (Exception e) {
        } catch (Error error) {
        }
        return strTime;
    }

    private static SimpleDateFormat getSimpleDateFormat(String template) {
        if (DATE_FORMAT.equals(template)) {
            return dateFormatCacheHyphen.get();
        } else if (DATE_FORMAT_YYYYMMDDHHMMSS.equals(template)) {
            return dateFormatCache_YYYYMMDDHHMMSS.get();
        } else if (DATE_FORMAT_YYYYMM.equals(template)) {
            return dateFormatCache_YYYYMM.get();
        } else if (DATE_FORMAT_YYYYMMDD.equals(template)) {
            return dateFormatCache_YYYYMMDD.get();
        } else if (DATE_SHOW.equals(template)) {
            return dateFormatCache_show.get();
        }
        return null;
    }



    public static void main(String[] args) {
        int months = getMonthSpace("20160301000000","20170201000000",DATE_FORMAT_YYYYMMDDHHMMSS);
        System.out.println(months);
        double factor = 6;
        //最终得出的库号
        int dbNo = (int)Math.ceil(months/factor);
        System.out.println(String.valueOf(dbNo));

        String s = formatTime("20170201000000", DATE_FORMAT_YYYYMMDDHHMMSS, DATE_FORMAT_YYYYMM);
        System.out.println(s);
    }
}
