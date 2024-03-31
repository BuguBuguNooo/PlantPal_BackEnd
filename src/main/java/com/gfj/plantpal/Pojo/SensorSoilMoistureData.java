package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是土壤湿度传感器实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SensorSoilMoistureData extends SensorBaseData {
    //土壤湿度
    @JsonProperty("SoilMoisture")
    private Double soilMoisture;
}
