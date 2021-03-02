package com.myd.dou.jdk8.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 14:42
 * @Description:
 */
public class CentreListResponse<T> implements Serializable {
    private static final long serialVersionUID = -7628952830016632166L;
    private List<T> dataList;

    public CentreListResponse() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
