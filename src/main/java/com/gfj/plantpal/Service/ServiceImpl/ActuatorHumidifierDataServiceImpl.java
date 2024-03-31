package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorHumidifierDataMapper;
import com.gfj.plantpal.Pojo.ActuatorHumidifierData;
import com.gfj.plantpal.Service.ActuatorHumidifierDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorHumidifierDataServiceImpl extends AbstractBatchDataService<ActuatorHumidifierData> implements ActuatorHumidifierDataService {
    @Autowired
    private ActuatorHumidifierDataMapper actuatorHumidifierDataMapper;
    @Override
    public void batchInsert(List<ActuatorHumidifierData> dataList) {
        actuatorHumidifierDataMapper.batchInsert(dataList);
    }
}
