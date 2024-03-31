package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.PlantTip;

import java.util.List;

public interface UserPlantTipService {
    //查询用户植物贴士列表
    List<PlantTip> SelectUserPlantTipList();
}
