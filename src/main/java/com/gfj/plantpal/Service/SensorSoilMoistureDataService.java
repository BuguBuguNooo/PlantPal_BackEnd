package com.gfj.plantpal.Service;


import com.gfj.plantpal.Pojo.SensorSoilMoistureData;

import java.util.List;

public interface SensorSoilMoistureDataService {
    //批量插入传感器数据
    void batchInsert(List<SensorSoilMoistureData> dataList);
    void addData(SensorSoilMoistureData data);
}
