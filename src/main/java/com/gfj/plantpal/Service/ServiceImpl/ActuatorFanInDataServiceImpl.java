package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorFanInDataMapper;
import com.gfj.plantpal.Pojo.ActuatorFanInData;
import com.gfj.plantpal.Service.ActuatorFanInDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorFanInDataServiceImpl extends AbstractBatchDataService<ActuatorFanInData> implements ActuatorFanInDataService {
    @Autowired
    private ActuatorFanInDataMapper actuatorFanInDataMapper;
    @Override
    public void batchInsert(List<ActuatorFanInData> dataList) {
        actuatorFanInDataMapper.batchInsert(dataList);
    }
}
