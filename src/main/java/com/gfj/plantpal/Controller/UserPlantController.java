package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.Result;
import com.gfj.plantpal.Pojo.UserPlant;
import com.gfj.plantpal.Service.UserPlantService;
import com.gfj.plantpal.Util.ThreadLocalUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/plant")
public class UserPlantController {
    @Autowired
    private UserPlantService userPlantService;
    //新增用户植物
    @PostMapping("/add")
    private Result insertUserPlant(@Valid @RequestBody UserPlant userPlant) {
        if (userPlant == null) {
            throw new IllegalArgumentException("UserPlant must not be null");
        }
        int i = userPlantService.insertUserPlant(userPlant);
        if (i > 0) {
            return Result.success("添加植物成功！");
        } else {
            return Result.error("添加植物失败！");
        }
    }
    //删除用户植物
    @DeleteMapping("/delete")
    private Result deleteUserPlant(@RequestParam Integer plantId, @RequestParam Integer userId) {
        if (plantId == null || userId == null) {
            throw new IllegalArgumentException("plantId and userId must not be null!");
        }
        int i = userPlantService.deleteUserPlant(plantId, userId);
        if (i > 0) {
            return Result.success("删除植物成功！");
        } else {
            return Result.error("删除植物失败！");
        }
    }
    //更新用户植物信息
    @PutMapping("/update")
    private Result updateUserPlant(@Valid @RequestBody UserPlant userPlant, @RequestParam Integer userId) {
        if (userPlant == null || userId == null) {
            throw new IllegalArgumentException("UserPlant and userId must not be null");
        }
        int i = userPlantService.updateUserPlant(userPlant);
        if (i > 0) {
            return Result.success("更新植物信息成功！");
        } else {
            return Result.error("更新植物信息失败！");
        }
    }
    //查询用户植物列表
    @GetMapping("/list")
    private Result selectUserPlantList(@RequestParam Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        return Result.success(userPlantService.selectUserPlantList(userId));
    }

    //更新植物图片
    @PutMapping("/updateImage")
    private Result updateUserPlantImage(@RequestParam String plantId, @RequestParam String imageUrl) {
        if (plantId == null || imageUrl == null) {
            throw new IllegalArgumentException("plantId and imageUrl must not be null");
        }
        int i = userPlantService.UpdateUserPlantPic(imageUrl, plantId);
        if (i > 0) {
            return Result.success("更新植物图片成功！");
        } else {
            return Result.error("更新植物图片失败！");
        }
    }
}
