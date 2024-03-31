package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.SensorTemHumData;

import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
public interface SensorTemHumDateService {
    //批量插入传感器数据
    void batchInsert(List<SensorTemHumData> dataList);
    void addData(SensorTemHumData data);
    //获取当天的平均温度（1）
    Double getDayAvgTem1();
    //获取当天的平均湿度（1）
    Double getDayAvgHum1();
    //获取当天的平均温度（2）
    Double getDayAvgTem2();
    //获取当天的平均湿度（2）
    Double getDayAvgHum2();
    //查询近一周内每天的最高温度
    List<Map<String, Object>> selectDayMaxTemRecentWeek();
    //查询近一周内每天的平均温度
    List<Map<String, Object>> selectDayAvgTemRecentWeek();
}
