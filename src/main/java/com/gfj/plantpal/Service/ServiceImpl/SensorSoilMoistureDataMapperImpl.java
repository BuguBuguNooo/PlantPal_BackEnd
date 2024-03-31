package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.SensorSoilMoistureDataMapper;
import com.gfj.plantpal.Pojo.SensorSoilMoistureData;
import com.gfj.plantpal.Service.SensorSoilMoistureDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorSoilMoistureDataMapperImpl extends AbstractBatchDataService<SensorSoilMoistureData> implements SensorSoilMoistureDataService {
    @Autowired
    private SensorSoilMoistureDataMapper sensorSoilMoistureDataMapper;
    @Override
    public void batchInsert(List<SensorSoilMoistureData> dataList) {
        sensorSoilMoistureDataMapper.batchInsert(dataList);
    }
}
