package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.ActuatorHeaterDataMapper;
import com.gfj.plantpal.Pojo.ActuatorHeaterData;
import com.gfj.plantpal.Service.ActuatorHeaterDataService;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorHeaterDataServiceImpl extends AbstractBatchDataService<ActuatorHeaterData> implements ActuatorHeaterDataService {
    @Autowired
    private ActuatorHeaterDataMapper actuatorHeaterDataMapper;
    @Override
    public void batchInsert(List<ActuatorHeaterData> dataList) {
        actuatorHeaterDataMapper.batchInsert(dataList);
    }

}
