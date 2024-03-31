package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.ActuatorHeaterData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ActuatorHeaterDataMapper {
    //批量插入传感器数据
    void batchInsert(List<ActuatorHeaterData> dataList);
}
