package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.SensorCO2Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface SensorCO2DataMapper {
    //批量插入传感器数据
    void batchInsert(List<SensorCO2Data> dataList);
    //查询近一天的二氧化碳平均数据
    Double selectAVGCO2RecentDay();
    //查询近一天的二氧化碳最大数据
    //Double selectMaxCO2RecentDay();
    //查询近一天的二氧化碳最小数据
//    Double selectMinCO2RecentDay();
//    //查询近一天的二氧化碳数据
//    List<SensorCO2Data> selectCO2RecentDay();
    //查询近一周的二氧化碳平均数据
    Double selectAVGCO2RecentWeek();
}
