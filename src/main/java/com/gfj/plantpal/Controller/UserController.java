package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.Result;
import com.gfj.plantpal.Pojo.User;
import com.gfj.plantpal.Service.UserService;
import com.gfj.plantpal.Util.JwtUtil;
import com.gfj.plantpal.Util.Md5Util;
import com.gfj.plantpal.Util.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    //注入一个userservice对象
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if(u == null){
            //未占用，注册
            userService.register(username, password);
            return Result.success();
        }else{
            //占用
            return Result.error("用户名已被占用哦～");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        //根据用户名查询用户
        User loginuser = userService.findByUserName(username);
        //判断是否查询到
        if (loginuser==null){
            return Result.error("用户名错误");
        }
        //判断密码对否
        if(Md5Util.getMD5String(password).equals(loginuser.getPassword())){
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginuser.getId());
            claims.put("username", loginuser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        //根据用户名查询用户
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User u = userService.findByUserName(username);
        return Result.success(u);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatarUrl(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if(StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(rePwd)){
            return Result.error("缺少必要的参数");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if(loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            if(newPwd.equals(rePwd)){
                //更新密码
                userService.updatePwd(newPwd);
                return Result.success();
            }else{
                return Result.error("两次密码不一致");
            }
        }else{
            return Result.error("原密码错误");
        }
    }
}
