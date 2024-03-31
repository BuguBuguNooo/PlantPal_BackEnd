package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是温湿度传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class SensorTemHumData extends SensorBaseData {
    //温度
    @JsonProperty("Temperature")
    private Double temperature;
    //湿度
    @JsonProperty("Humidity")
    private Double humidity;
}
