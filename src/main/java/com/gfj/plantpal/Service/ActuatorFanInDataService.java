package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorFanInData;

import java.util.List;

public interface ActuatorFanInDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorFanInData> dataList);
    void addData(ActuatorFanInData data);
}
