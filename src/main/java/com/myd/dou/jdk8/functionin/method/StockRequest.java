package com.myd.dou.jdk8.functionin.method;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/7 10:17
 * @Description:
 */
@Getter
@Setter
@ToString
public class StockRequest {
    private String noteNo;
    private String changeAmount;
    private String changeStock;
    private String remark;
}
