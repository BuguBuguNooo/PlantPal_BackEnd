package com.gfj.plantpal.ServiceUtil;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public abstract class AbstractBatchDataService<T> {
    //创建一个线程安全队列，用于存放传感器数据
    private final Queue<T> dataQueue = new ConcurrentLinkedQueue<>();
    //将数据添加到队列中
    public void addData(T data) {
        dataQueue.add(data);
    }
    //定时任务，每10秒执行一次
    @Scheduled(fixedRate = 10000)
    @Transactional
    protected void batchInsertTask() {
        List<T> dataList = new ArrayList<>(dataQueue);
        dataQueue.clear();
        if (!dataList.isEmpty()) {
            batchInsert(dataList);
        }
    }
    //批量插入传感器数据
    protected abstract void batchInsert(List<T> dataList);
}
