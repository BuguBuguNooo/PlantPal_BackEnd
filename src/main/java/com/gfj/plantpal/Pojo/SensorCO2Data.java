package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是二氧化碳传感器实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SensorCO2Data extends SensorBaseData {
    //二氧化碳浓度
    @JsonProperty("CO2")
    private Double co2;
}
