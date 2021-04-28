package com.myd.dou.jdk8.functionin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/26 19:24
 * @Description:
 */
public class AppenderTest {

    public static void main(String[] args) {

        SkuPurchaseForm form = new SkuPurchaseForm();
        form.setName("大曦");
        form.setAge(5);
        form.setSchool("二幼");
        SkuPurchaseForm.AddreForm addreForm1 = new SkuPurchaseForm.AddreForm();
        addreForm1.setAddName("本部");
        addreForm1.setAddCode("001");
        SkuPurchaseForm.AddreForm addreForm2 = new SkuPurchaseForm.AddreForm();
        addreForm2.setAddName("分部");
        addreForm2.setAddCode("002");
        List<SkuPurchaseForm.AddreForm> addreForms = new ArrayList<>();
        addreForms.add(addreForm1);
        addreForms.add(addreForm2);
        form.setAddreList(addreForms);

        SkuPurchaseRequest request = new SkuPurchaseRequest();
        request.setName(form.getName());
        request.setAge(form.getAge());
        request.setSchool(form.getSchool());
        request.getAppender(form.getAddreList()).processor((m,builder)->builder.addreName(m.getAddName()).addreCode(m.getAddCode()).build()).append();

        System.out.println(request);
    }
}
