package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.PlantTip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPlantTipMapper {

    //查询用户植物提示列表
    List<PlantTip> selectUserPlantTipList();

}
