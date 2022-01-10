package com.myd.dou.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/21 17:02
 * @Description:
 */
public class Test3 {


    public static void main(String[] args) throws UnknownHostException {
        int[] aa = new int[]{1,2,3};
        System.out.println(aa[0]);

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress:"+addr.getHostAddress());
                String hostname = addr.getHostName();
        System.out.println("Local host name: "+hostname);

    }


}
