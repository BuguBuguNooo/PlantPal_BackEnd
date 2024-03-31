package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.Result;
import com.gfj.plantpal.Service.SensorTemHumDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/temhum")
public class SensorTemHumController {

    @Autowired
    private SensorTemHumDateService sensorTemHumDateService;

    // 获取当天平均温度（1）
    @GetMapping("/getDayTem")
    public Result<Double> getDayTem1() {
        Double dayAvgTem1 = sensorTemHumDateService.getDayAvgTem1();
        Double dayAvgTem2 = sensorTemHumDateService.getDayAvgTem2();
        if (dayAvgTem1 != null && dayAvgTem2 != null) {
            return Result.success((dayAvgTem1 + dayAvgTem2) / 2);
        } else {
            return Result.error("无法获取当天平均温度");
        }
    }
    // 获取当天平均湿度（1）
    @GetMapping("/getDayHum")
    public Result<Double> getDayHum1() {
        Double dayAvgHum1 = sensorTemHumDateService.getDayAvgHum1();
        Double dayAvgHum2 = sensorTemHumDateService.getDayAvgHum2();
        if (dayAvgHum1 != null&& dayAvgHum2 != null) {
            Double dayHum = (dayAvgHum1 + dayAvgHum2) / 2;
            return Result.success(dayAvgHum1);
        } else {
            return Result.error("无法获取当天平均湿度");
        }
    }
    // 查询近一周内每天的最高温度
    @GetMapping("/getDayMaxTemRecentWeek")
    private Result<List<Map<String, Object>>> getDayMaxTemRecentWeek() {
        List<Map<String, Object>> dayMaxTemRecentWeek = sensorTemHumDateService.selectDayMaxTemRecentWeek();
        if (dayMaxTemRecentWeek != null) {
            return Result.success(dayMaxTemRecentWeek);
        } else {
            return Result.error("无法获取近一周内每天的最高温度");
        }
    }
    // 查询近一周内每天的平均温度
    @GetMapping("/getDayAvgTemRecentWeek")
    private Result<List<Map<String, Object>>> getDayAvgTemRecentWeek() {
        List<Map<String, Object>> dayAvgTemRecentWeek = sensorTemHumDateService.selectDayAvgTemRecentWeek();
        if (dayAvgTemRecentWeek != null) {
            return Result.success(dayAvgTemRecentWeek);
        } else {
            return Result.error("无法获取近一周内每天的平均温度");
        }
    }
}
