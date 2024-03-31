package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.SensorEnergyMeterData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface SensorEnergyMeterDataMapper {
    //批量插入传感器数据
    void batchInsert(List<SensorEnergyMeterData> dataList);
}
