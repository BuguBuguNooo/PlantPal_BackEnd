package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorLEDDataMapper;
import com.gfj.plantpal.Pojo.ActuatorLEDData;
import com.gfj.plantpal.Service.ActuatorLEDDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorLEDDataServiceImpl extends AbstractBatchDataService<ActuatorLEDData> implements ActuatorLEDDataService {
    @Autowired
    private ActuatorLEDDataMapper actuatorLEDDataMapper;
    @Override
    public void batchInsert(List<ActuatorLEDData> dataList) {
        actuatorLEDDataMapper.batchInsert(dataList);
    }
}
