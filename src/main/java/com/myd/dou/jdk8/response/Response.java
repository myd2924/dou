package com.myd.dou.jdk8.response;

import java.util.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 10:32
 * @Description:
 */
public class Response {
    public static <T, V> CentreResponse<V> toResponse(T result, ResponseConverter<T, V> converter) {
        CentreResponse<V> response = new CentreResponse();
        response.setData(null != result ? converter.convert(result) : null);
        return response;
    }

    public static <T, V> CentreListResponse<V> toListResponse(List<T> result, ResponseConverter<T, V> converter) {
        CentreListResponse<V> response = new CentreListResponse();
        response.setDataList(convert(result, converter));
        return response;
    }

    static <S, T> List<T> convert(Collection<S> sources, ResponseConverter<S, T> converter) {
        if (null != sources && !sources.isEmpty()) {
            if (null == converter) {
                throw new NullPointerException("程序代码错误，converter转换器为null");
            } else {
                List<T> result = new ArrayList(sources.size());
                Iterator var3 = sources.iterator();

                while(var3.hasNext()) {
                    S s = (S)var3.next();
                    T v = converter.convert(s);
                    if (v != null) {
                        result.add(v);
                    }
                }

                return result;
            }
        } else {
            return Collections.emptyList();
        }
    }
}
