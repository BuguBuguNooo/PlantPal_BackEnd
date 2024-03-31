package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.SensorTemHumData;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
@Mapper
public interface SensorTemHumDataMapper {

    //批量插入传感器数据
    void batchInsert(List<SensorTemHumData> dataList);
    //查询近一天的温度平均数据（1）
    Double selectAVGTemRecentDay1();
    //查询近一天的湿度数据（2）
    Double selectAVGHumRecentDay1();
    //查询近一天的温度平均数据（2）
    Double selectAVGTemRecentDay2();
    //查询近一天的湿度数据（2）
    Double selectAVGHumRecentDay2();

    //图表展示模块
    //查询近一周内每天的最高温度（1）
    @MapKey("Date")
    List<Map<String, Object>> selectDayMaxTemRecentWeek();

    //查询近一周内每天的平均温度（1）
    @MapKey("Date")
    List<Map<String, Object>> selectDayAvgTemRecentWeek();

}
