package com.myd.dou.jdk8.functionin.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/7 10:14
 * @Description:
 */
public class MethodTest {
    public static void main(String[] args) {
        StockService service = new StockService();
        StockDetailRequest request1 = new StockDetailRequest();
        request1.setBillType("1200");
        request1.setNoteNo("4646");
        request1.setChangeAmount("4464");
        request1.setChangeStock("466666");
        request1.setRemark("efs");

        StockDetailRequest request2 = new StockDetailRequest();
        request2.setBillType("1200");
        request2.setNoteNo("4646");
        request2.setChangeAmount("4464");
        request2.setChangeStock("466666");
        request2.setRemark("efs");
        List<StockDetailRequest> list = new ArrayList<>();
        list.add(request1);
        list.add(request2);
        service.stock(list);


        StockRequest request = new StockRequest();
        request.setChangeAmount("ef");
        List<StockRequest> lists = new ArrayList<>();
        lists.add(request);
        service.stock(lists);
    }
}
