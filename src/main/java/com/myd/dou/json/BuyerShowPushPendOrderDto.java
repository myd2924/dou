package com.myd.dou.json;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName BuyerShowPushPendOrderDto
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/12 14:38
 * @Version 1.0
 **/
public class BuyerShowPushPendOrderDto {
    /**
     * OMS订单行项目号
     */
    private String orderItemId;

    /**
     * OMS订单项目号
     */
    private String orderId;


    /**
     * 商品编码
     */
    private String commodityCode;


    /**
     * 商户店铺ID
     */
    private String shopId;

    /**
     * 门店ID
     */
    private String storeId;

    /**
     * 会员号
     */
    private String custNum;


    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
