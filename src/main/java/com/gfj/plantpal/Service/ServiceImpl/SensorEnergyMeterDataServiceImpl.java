package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.SensorEnergyMeterDataMapper;
import com.gfj.plantpal.Pojo.SensorEnergyMeterData;
import com.gfj.plantpal.Service.SensorEnergyMeterDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorEnergyMeterDataServiceImpl extends AbstractBatchDataService<SensorEnergyMeterData> implements SensorEnergyMeterDataService {

    @Autowired
    private SensorEnergyMeterDataMapper sensorEnergyMeterDataMapper;

    @Override
    public void batchInsert(List<SensorEnergyMeterData> dataList) {
        sensorEnergyMeterDataMapper.batchInsert(dataList);
    }
}
