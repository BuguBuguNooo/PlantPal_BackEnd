package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorFanOutData;

import java.util.List;

public interface ActuatorFanOutDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorFanOutData> dataList);
    void addData(ActuatorFanOutData data);
}
