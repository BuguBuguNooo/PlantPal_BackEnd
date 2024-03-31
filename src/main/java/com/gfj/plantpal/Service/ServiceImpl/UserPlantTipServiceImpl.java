package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.UserPlantTipMapper;
import com.gfj.plantpal.Pojo.PlantTip;
import com.gfj.plantpal.Service.UserPlantTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserPlantTipServiceImpl implements UserPlantTipService {

    @Autowired
    private UserPlantTipMapper userPlantTipMapper;
    @Override
    public List<PlantTip> SelectUserPlantTipList() {
        return userPlantTipMapper.selectUserPlantTipList();
    }
}
