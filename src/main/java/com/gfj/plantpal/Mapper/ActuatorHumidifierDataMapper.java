package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.ActuatorHumidifierData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ActuatorHumidifierDataMapper {
    //批量插入传感器数据
    void batchInsert(List<ActuatorHumidifierData> dataList);
}
