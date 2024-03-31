package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorChillerData;

import java.util.List;

public interface ActuatorChillerDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorChillerData> dataList);
    void addData(ActuatorChillerData data);
}
