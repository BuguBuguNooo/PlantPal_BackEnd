package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.SensorEnergyMeterData;

import java.util.List;

public interface SensorEnergyMeterDataService {
    //批量插入传感器数据
    void batchInsert(List<SensorEnergyMeterData> dataList);
    void addData(SensorEnergyMeterData data);
}
