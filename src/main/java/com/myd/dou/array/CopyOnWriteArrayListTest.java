package com.myd.dou.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/3/11 10:13
 * @Description: https://blog.csdn.net/qq_35634181/article/details/106870107
 */
@Slf4j
public class CopyOnWriteArrayListTest {

    @Test
    public void testList() throws InterruptedException {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<String> listcopy = new CopyOnWriteArrayList<>(list);
        Iterator<String> iterator = list.iterator();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        threadPool.execute(()->{
            for(int j=0;j<5;j++){
                listcopy.add(j * 8 + "");
            }
        });

        for(int i=0;i<10;i++){
            threadPool.execute(()->{
                while (iterator.hasNext()){
                    log.info(iterator.next());
                }
            });
        }

        Thread.sleep(3000);
        Iterator<String> iterator2 = listcopy.iterator();
        for(int i=0;i<10;i++){
            threadPool.execute(()->{
                while (iterator2.hasNext()){
                    log.info(iterator2.next());
                }
            });
        }
    }

}
