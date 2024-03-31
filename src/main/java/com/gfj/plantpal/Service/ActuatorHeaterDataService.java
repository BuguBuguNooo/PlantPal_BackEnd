package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.ActuatorHeaterData;

import java.util.List;

public interface ActuatorHeaterDataService {
    //批量插入传感器数据
    void batchInsert(List<ActuatorHeaterData> dataList);
    void addData(ActuatorHeaterData data);
}
