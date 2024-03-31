package com.gfj.plantpal.Service.ServiceImpl;


import com.gfj.plantpal.Mapper.UserMapper;
import com.gfj.plantpal.Pojo.User;
import com.gfj.plantpal.Service.UserService;
import com.gfj.plantpal.Util.Md5Util;
import com.gfj.plantpal.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author gefangjie
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密处理
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username, md5String);
    }

    @Override
    public void update(User user) {
        //获取当前时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatarUrl(String avatatUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
       Integer id = (Integer) map.get("id");
        userMapper.updateAvatarUrl(avatatUrl, id);
    }

    @Override
    public void updatePwd(String password) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        String md5String = Md5Util.getMD5String(password);
        userMapper.updatePwd(md5String, id);
    }
}
