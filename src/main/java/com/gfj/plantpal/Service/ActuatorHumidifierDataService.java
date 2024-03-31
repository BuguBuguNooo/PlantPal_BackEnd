package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorHumidifierData;

import java.util.List;

public interface ActuatorHumidifierDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorHumidifierData> dataList);
    void addData(ActuatorHumidifierData data);
}
