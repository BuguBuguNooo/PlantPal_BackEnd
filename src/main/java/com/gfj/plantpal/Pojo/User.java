package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gefangjie
 */ //lombok 在编译阶段为实体类自动生成set，get，tostring方法
@Data
public class User {
    @NotNull
    private Integer id;
    //主键ID
    private String username;
    //用户名
    @JsonIgnore//返回json时忽略密码这个字段
    private String password;
    //密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    //昵称
    @NotEmpty
    @Email
    private String email;
    //邮箱
    private String userPic;
    //用户头像地址
    private LocalDateTime createTime;
    //创建时间
    private LocalDateTime updateTime;
    //更新时间
}
