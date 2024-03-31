package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.SensorSoilMoistureData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface SensorSoilMoistureDataMapper {
    //批量插入传感器数据
    void batchInsert(List<SensorSoilMoistureData> dataList);
    //查询近一天的土壤湿度平均数据
}
