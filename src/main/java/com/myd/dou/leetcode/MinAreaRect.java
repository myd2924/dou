package com.myd.dou.leetcode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/1 11:22
 * @Description: 939  最小面积矩形  暴力解法
 */
public class MinAreaRect {
    
    static int[][] rect = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
    static int [][] rect1 = {{1,1},{1,3},{3,1},{3,3},{2,2}};

    public static void main(String[] args) {
        System.out.println(minAreaRect(rect));
        System.out.println(minAreaRect(rect1));
    }

    public static int minAreaRect(int[][] points) {
        int result = 0;
        if(Objects.isNull(points)){
            return result;
        }
        result = Integer.MAX_VALUE;
        final int length =  points.length;
        for(int i=0;i<length;i++){
            int[] pointm = points[i];
            for(int j=i+1;j<length;j++){
                int[] pointn = points[j];
                if(pointm[0]==pointn[0] || pointm[1]==pointn[1]){
                    continue;
                }
                AtomicInteger countFlag = new AtomicInteger(0);
                for(int m=0;m<length;m++){
                    if(points[m][0] ==  pointm[0] && points[m][1] == pointn[1]){
                        countFlag.getAndIncrement();
                    }
                    if(points[m][0] ==  pointn[0] && points[m][1] == pointm[1]){
                        countFlag.getAndIncrement();
                    }

                    if(countFlag.get() == 2){
                        result = Math.min(result,Math.abs((pointm[0]-pointn[0])*(pointm[1]-pointn[1])));
                        break;
                    }
                }
            }
        }


        return result==Integer.MAX_VALUE?0:result;
    }
}
