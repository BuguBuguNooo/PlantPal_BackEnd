package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorPumpData;

import java.util.List;

public interface ActuatorPumpDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorPumpData> dataList);
    void addData(ActuatorPumpData data);
}
