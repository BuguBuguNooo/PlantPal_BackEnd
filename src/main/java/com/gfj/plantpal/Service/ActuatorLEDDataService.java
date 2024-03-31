package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorLEDData;

import java.util.List;

public interface ActuatorLEDDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorLEDData> dataList);
    void addData(ActuatorLEDData data);
}
