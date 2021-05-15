package com.myd.dou.jdk8.functionin.method;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/7 10:15
 * @Description:
 */
@Data
@NoArgsConstructor
public class StockService {

    public <T extends StockRequest> void stock(final Collection<T> request){
        List<StockDetailRequest> collect = request.stream()
                .filter(t -> t instanceof StockDetailRequest)
                .map(re -> (StockDetailRequest) re)
                .collect(Collectors.toList());

        System.out.println(collect);

    }

}
