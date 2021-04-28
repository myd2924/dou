package com.myd.dou.jdk8.jdk8stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/27 20:05
 * @Description:
 */
@Data
@AllArgsConstructor
public class Num {

    private BigDecimal cost;

    private BigDecimal stock;

    private BigDecimal amount;
}
