package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.SensorSoilEntropyDataMapper;
import com.gfj.plantpal.Pojo.SensorSoilEntropyData;
import com.gfj.plantpal.ServiceUtil.AbstractBatchDataService;
import com.gfj.plantpal.Service.SensorSoilEntropyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author gefangjie
 */
@Service
public class SensorSoilEntropyDataServiceImpl extends AbstractBatchDataService<SensorSoilEntropyData> implements SensorSoilEntropyDataService {
    @Autowired
    private SensorSoilEntropyDataMapper sensorSoilEntropyDataMapper;

    @Override
    public void batchInsert(List<SensorSoilEntropyData> dataList) {
        sensorSoilEntropyDataMapper.batchInsert(dataList);
    }
    @Override
    public Double selectAVGConductivityRecentDay() {
        return null;
    }

}
