package com.gfj.plantpal.Mapper;


import com.gfj.plantpal.Pojo.ActuatorFanOutData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ActuatorFanOutDataMapper {
    //批量插入传感器数据
    void batchInsert(List<ActuatorFanOutData> dataList);
}
