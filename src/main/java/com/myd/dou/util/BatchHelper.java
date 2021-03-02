package com.myd.dou.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/3 15:34
 * @Description: 批量处理数据方法
 */
public abstract class BatchHelper<T> {
    /**
     * 默认批次大小
     */
    private static final Integer DEFAULT_SIZE = 100;

    /**
     * 一次数量
     */
    private final Integer oneBatchCount;

    /**
     * 数据集合
     */
    private final Collection<T> dataList;

    public BatchHelper(Collection<T> dataList){
        this(dataList,100);
    }

    public BatchHelper(Collection<T> dataList,Integer oneBatchCount){
        this.dataList = dataList;
        this.oneBatchCount = oneBatchCount;
    }

    public abstract void eachBatch(List<T> eachList);


    public void executeBatch() {
        if(CollectionUtils.isEmpty(dataList)){
            return ;
        }
        List<T> listUse = this.dataList instanceof List ? (List) this.dataList : new ArrayList<>(this.dataList);
        int pageSize = this.oneBatchCount;
        int pageNo = listUse.size() / pageSize;
        int lastPageCount = listUse.size() % pageSize;
        if(lastPageCount == 0){
            --pageNo;
        }

        for (int i=0;i<=pageNo;i++){
            int fromIndex = i*pageSize;
            int toIndex = i == pageNo && lastPageCount != 0 ? i+pageSize+lastPageCount : (i+1)*pageSize-1;
            this.eachBatch(listUse.subList(fromIndex,toIndex+1));
        }

    }


}
