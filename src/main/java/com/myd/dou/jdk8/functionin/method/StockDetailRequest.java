package com.myd.dou.jdk8.functionin.method;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/7 10:21
 * @Description:
 */
@Getter
@Setter

public class StockDetailRequest extends StockRequest {

    private String billType;

    @Override
    public String toString() {
        return super.toString()+"StockDetailRequest{" +
                "billType='" + billType + '\'' +
                '}';
    }
}
