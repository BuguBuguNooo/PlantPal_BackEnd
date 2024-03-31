package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.SensorSoilEntropyData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface SensorSoilEntropyDataMapper {
    //批量插入传感器数据
    void batchInsert(List<SensorSoilEntropyData> dataList);
    //查询近一天的土壤导电率平均数据
    Double selectAVGConductivityRecentDay();


}
