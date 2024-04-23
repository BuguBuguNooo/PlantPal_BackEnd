package com.gfj.plantpal.Pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author gefangjie
 */
@Data
@NoArgsConstructor
public class UserPlant {
    //植物id
    private Integer plantId;
    //用户id
    private Integer userId;
    //植物名称
    @NotNull(message = "植物名称不能为空")
    private String plantName;
    //用户的植物序号
    private Integer plantSqId;
    //植物图片
    private String plantPic;
    //植物最低适宜温度
    private BigDecimal optimalTempLow;
    //植物最高适宜温度
    private BigDecimal optimalTempHigh;
    //植物最低适宜湿度
    private BigDecimal optimalHumidityLow;
    //植物最高适宜湿度
    private BigDecimal optimalHumidityHigh;
    //植物最低适宜光照强度
    private BigDecimal optimalLightIntensity;
    //植物最低适宜光照时长
    private Integer optimalLightDuration;
    //植物最低适宜二氧化碳浓度
    private BigDecimal optimalCo2Low;
    //植物最高适宜二氧化碳浓度
    private BigDecimal optimalCo2High;
    //植物最低适宜ph值
    private BigDecimal optimalPhLow;
    //植物最高适宜ph值
    private BigDecimal optimalPhHigh;
    //植物最低适宜土壤湿度
    private BigDecimal optimalSoilMoistureLow;
    //植物最高适宜土壤湿度
    private BigDecimal optimalSoilMoistureHigh;
}
