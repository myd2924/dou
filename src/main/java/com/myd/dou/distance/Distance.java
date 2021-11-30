package com.myd.dou.distance;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/26 13:53
 * @Description: 根据经纬度计算距离
 */
public class Distance {

    private static final double EARTH_RADIUS = 6378.137;

    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为M）
     * 参数为double类型
     *  long1 位置1经度
     *  lat1  位置1纬度
     *  long2 位置2经度
     *  lat2  位置2纬度
     *
     * @return 返回距离 单位千米
     */

    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 千米
        s =  s * EARTH_RADIUS;
        return s;
    }

    public static void main(String[] args) {
        //根据两点间的经纬度计算距离，单位：m
        System.out.println(getDistance(114.21221, 22.68301, 114.21229, 22.68309)*1000);
    }

}
