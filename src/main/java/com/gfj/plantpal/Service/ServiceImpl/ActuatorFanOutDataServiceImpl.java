package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorFanOutDataMapper;
import com.gfj.plantpal.Pojo.ActuatorFanOutData;
import com.gfj.plantpal.Service.ActuatorFanOutDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorFanOutDataServiceImpl extends AbstractBatchDataService<ActuatorFanOutData> implements ActuatorFanOutDataService {
    @Autowired
    private ActuatorFanOutDataMapper actuatorFanOutDataMapper;
    @Override
    public void batchInsert(List<ActuatorFanOutData> dataList) {
        actuatorFanOutDataMapper.batchInsert(dataList);
    }
}
