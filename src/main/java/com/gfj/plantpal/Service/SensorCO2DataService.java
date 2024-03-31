package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.SensorCO2Data;

import java.util.List;

public interface SensorCO2DataService {
    //批量插入传感器数据
    void batchInsert(List<SensorCO2Data> dataList);
    void addData(SensorCO2Data data);
    //查询近一天的二氧化碳平均数据
    Double selectAVGCO2RecentDay();
    //查询近一天的二氧化碳最大数据
    Double selectMaxCO2RecentDay();
    //查询近一天的二氧化碳最小数据
}
