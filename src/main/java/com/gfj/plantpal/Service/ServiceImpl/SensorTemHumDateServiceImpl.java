package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Pojo.SensorTemHumData;
import com.gfj.plantpal.Service.SensorTemHumDateService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gfj.plantpal.Mapper.SensorTemHumDataMapper;

import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
@Service
public class SensorTemHumDateServiceImpl extends AbstractBatchDataService<SensorTemHumData> implements SensorTemHumDateService {
    @Autowired
    private SensorTemHumDataMapper sensorTemHumDataMapper;
    @Override
    public void batchInsert(List<SensorTemHumData> dataList) {
        sensorTemHumDataMapper.batchInsert(dataList);
    }
    //获取当天的平均温度（1）
    @Override
    public Double getDayAvgTem1() {
        return sensorTemHumDataMapper.selectAVGTemRecentDay1();
    }
    //获取当天的平均湿度（1）
    @Override
    public Double getDayAvgHum1() {
        return sensorTemHumDataMapper.selectAVGHumRecentDay1();
    }
    //获取当天的平均温度（2）
    @Override
    public Double getDayAvgTem2() {
        return sensorTemHumDataMapper.selectAVGTemRecentDay2();
    }
    //获取当天的平均湿度（2）
    @Override
    public Double getDayAvgHum2() {
        return sensorTemHumDataMapper.selectAVGHumRecentDay2();
    }

    @Override
    public List<Map<String, Object>> selectDayMaxTemRecentWeek() {
        return sensorTemHumDataMapper.selectDayMaxTemRecentWeek();
    }

    @Override
    public List<Map<String, Object>> selectDayAvgTemRecentWeek() {
        return sensorTemHumDataMapper.selectDayAvgTemRecentWeek();
    }


}
