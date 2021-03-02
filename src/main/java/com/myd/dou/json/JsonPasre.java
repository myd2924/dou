package com.myd.dou.json;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName JsonPasre
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/12 14:33
 * @Version 1.0
 **/
public class JsonPasre {
    public static void main(String[] args) {
        String str = "{\"commodityCode\":\"000000000121347653\",\n" +
                "\"custNum\":\"7018158386\",\n" +
                "\"orderId\":\"001056370556\",\n" +
                "\"orderItemId\":\"00105637055601\",\n" +
                "\"shopId\":\"10022340\",\n" +
                "\"storeId\":\"8884\"}";
        BuyerShowPushPendOrderDto buyerShowPushPendOrderDto = JSON.parseObject(str, BuyerShowPushPendOrderDto.class);
        System.out.println(buyerShowPushPendOrderDto);
    }
}
