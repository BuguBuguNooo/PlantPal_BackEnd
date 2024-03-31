package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorPumpDataMapper;
import com.gfj.plantpal.Pojo.ActuatorPumpData;
import com.gfj.plantpal.Service.ActuatorPumpDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorPumpDataServiceImpl extends AbstractBatchDataService<ActuatorPumpData> implements ActuatorPumpDataService {
    @Autowired
    private ActuatorPumpDataMapper actuatorPumpDataMapper;
    @Override
    public void batchInsert(List<ActuatorPumpData> dataList) {
        actuatorPumpDataMapper.batchInsert(dataList);
    }
}
