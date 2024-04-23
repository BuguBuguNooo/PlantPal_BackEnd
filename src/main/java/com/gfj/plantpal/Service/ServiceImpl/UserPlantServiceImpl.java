package com.gfj.plantpal.Service.ServiceImpl;

import com.gfj.plantpal.Mapper.UserPlantMapper;
import com.gfj.plantpal.Pojo.UserPlant;
import com.gfj.plantpal.Service.UserPlantService;
import com.gfj.plantpal.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
@Service
public class UserPlantServiceImpl implements UserPlantService {

    private final UserPlantMapper userPlantMapper;

    public UserPlantServiceImpl(UserPlantMapper userPlantMapper) {
        this.userPlantMapper = userPlantMapper;
    }

    @Override
    public int insertUserPlant(UserPlant userPlant) {
        //获取用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        //设置用户id
        userPlant.setUserId(id);
        //获取用户最大植物序号
        Integer maxSqNum = userPlantMapper.selectMaxSqNumByUserId(id);
        if(maxSqNum == null){
            userPlant.setPlantSqId(1);
        }else{
            userPlant.setPlantSqId(maxSqNum + 1);
        }
        //插入用户植物
        int result = userPlantMapper.InsertUserPlant(userPlant);
        System.out.println("Insert result: " + result);
        return result;
    }

    @Override
    public int deleteUserPlant(Integer plantId, Integer userId) {
        //删除用户植物
        return userPlantMapper.DeleteUserPlant(plantId, userId);
    }

    @Override
    public int updateUserPlant(UserPlant userPlant) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return userPlantMapper.UpdateUserPlant(userPlant,id);
    }

    @Override
    public List<UserPlant> selectUserPlantList(Integer userId) {
        return userPlantMapper.SelectUserPlantList(userId);
    }

    @Override
    public int UpdateUserPlantPic(String plantPic, String plantId) {
        return userPlantMapper.UpdateUserPlantPic(plantPic, plantId);
    }

}
