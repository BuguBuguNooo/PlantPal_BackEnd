package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.ActuatorFanInData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ActuatorFanInDataMapper {
    //批量插入传感器数据
    void batchInsert(List<ActuatorFanInData> dataList);
}
