package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.PlantTip;
import com.gfj.plantpal.Pojo.Result;
import com.gfj.plantpal.Service.UserPlantTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plantTip")
public class PlantTipController {
    @Autowired
    private UserPlantTipService userPlantTipService;

    //查询用户植物贴士列表
    @RequestMapping("/list")
    public Result<List<PlantTip>> list() {
        List<PlantTip> plantTips = userPlantTipService.SelectUserPlantTipList();
        if(plantTips.size() == 0) {
            return Result.error("查询失败");
        }else {
            return Result.success(plantTips);
        }
    }

}
