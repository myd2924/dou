package com.myd.dou.string;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/7/26 15:36
 * @Description: TODO
 */
public class Test1 {
    public static void main(String[] args) {
        String st = "ah,jj,kk";
        System.out.println(st.indexOf("ah"));
        String sh = "sdfhks.000";
        if(sh.endsWith(".000")){
            System.out.println(sh.substring(0,sh.indexOf(".")));
        }
        Integer ch = null;
        if(Integer.valueOf(1).equals(ch)){
            System.out.println("hahah");
        }

        for (int i=0;i<5;i++){
            System.out.println(i);
        }

    }
}
