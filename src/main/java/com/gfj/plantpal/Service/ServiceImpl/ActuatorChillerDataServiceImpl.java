package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorChillerDataMapper;
import com.gfj.plantpal.Pojo.ActuatorChillerData;
import com.gfj.plantpal.Service.ActuatorChillerDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActuatorChillerDataServiceImpl extends AbstractBatchDataService<ActuatorChillerData> implements ActuatorChillerDataService {

    @Autowired
    private ActuatorChillerDataMapper actuatorChillerDataMapper;
    @Override
    public void batchInsert(List<ActuatorChillerData> dataList) {
        actuatorChillerDataMapper.batchInsert(dataList);
    }
}
