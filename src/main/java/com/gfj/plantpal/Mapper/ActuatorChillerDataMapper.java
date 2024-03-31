package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.ActuatorChillerData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActuatorChillerDataMapper {
    //批量插入传感器数据
    void batchInsert(List<ActuatorChillerData> dataList);
}
