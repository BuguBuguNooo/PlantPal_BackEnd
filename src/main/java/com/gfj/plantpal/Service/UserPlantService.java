package com.gfj.plantpal.Service;

import com.gfj.plantpal.Pojo.UserPlant;

import java.util.List;

/**
 * @author gefangjie
 */
public interface UserPlantService {
    //新增用户植物
    int insertUserPlant(UserPlant userPlant);
    //删除用户植物
    int deleteUserPlant(Integer plantId, Integer userId);
    //更新用户植物信息
    int updateUserPlant(UserPlant userPlant);
    //查询用户植物列表
    List<UserPlant> selectUserPlantList(Integer userId);
    //更新植物图片
    int UpdateUserPlantPic(String plantPic, String plantId);
}
