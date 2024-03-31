package com.gfj.plantpal.Mapper;

import com.gfj.plantpal.Pojo.UserPlant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface UserPlantMapper {
    //查询用户植物最大序号
    Integer selectMaxSqNumByUserId(Integer userId);

    //新增用户植物
    int InsertUserPlant(UserPlant userPlant);
    //删除用户植物
    int DeleteUserPlant(Integer plantId, Integer userId);
    //更新用户植物信息
    int UpdateUserPlant(@Param("userPlant") UserPlant userPlant, @Param("userId") Integer userId);
    //查询用户植物列表
    List<UserPlant> SelectUserPlantList(Integer userId);
}
