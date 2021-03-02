package com.myd.dou.jdk8.response;

import java.io.Serializable;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 10:35
 * @Description: TODO
 */
public class CentreResponse<T> implements Serializable{
    private static final long serialVersionUID = 4402786172423388399L;
    private T data;

    public CentreResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
