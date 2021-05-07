package com.myd.dou.jdk8.jdk8stream;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/21 11:18
 * @Description:
 */
@Data
public class User2 {
    private int sequenceNo;
    private BigDecimal age;
    private String name;

    public User2(BigDecimal age, String name) {
        this.age = age;
        this.name = name;
    }

    public BigDecimal getProcessAge(){
        if(Objects.isNull(this.age)){
            this.age = new BigDecimal(0);
        }
        return this.age;
    }
}
