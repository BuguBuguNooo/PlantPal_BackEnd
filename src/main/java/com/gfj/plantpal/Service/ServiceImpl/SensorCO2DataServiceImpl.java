package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.SensorCO2DataMapper;
import com.gfj.plantpal.Pojo.SensorCO2Data;
import com.gfj.plantpal.Service.SensorCO2DataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gefangjie
 */
@Service
public class SensorCO2DataServiceImpl extends AbstractBatchDataService<SensorCO2Data> implements SensorCO2DataService {
    @Autowired
    private SensorCO2DataMapper sensorCO2DataMapper;
    @Override
    public void batchInsert(List<SensorCO2Data> dataList) {
        sensorCO2DataMapper.batchInsert(dataList);
    }
    @Override
    public Double selectAVGCO2RecentDay() {
        return null;
    }
    @Override
    public Double selectMaxCO2RecentDay() {
        return null;
    }

}