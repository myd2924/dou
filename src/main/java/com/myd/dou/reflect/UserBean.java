package com.myd.dou.reflect;

import com.myd.dou.annotation.ExcelField;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/30 18:12
 * @Description:
 */
@Getter
@Setter
public class UserBean {
    /**唯一标识*/
    @ExcelField(headerName = "序号")
    private String id;
    /**姓名*/
    @ExcelField(headerName = "名称")
    private String name;

    @ExcelField(headerName = "价格")
    private BigDecimal price;
}
