package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.SensorSoilEntropyData;

import java.util.List;

/**
 * @author gefangjie
 */
public interface SensorSoilEntropyDataService {
    //批量插入传感器数据
    void batchInsert(List<SensorSoilEntropyData> dataList);
    void addData(SensorSoilEntropyData data);
    //查询近一天的土壤导电率平均数据
    Double selectAVGConductivityRecentDay();
}
