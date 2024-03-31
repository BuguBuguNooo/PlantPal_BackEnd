package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是加湿器传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorHumidifierData extends ActuatorBaseData{
    //加湿器的开关状态
    @JsonProperty("Humidifier")
    private Integer humidifier;
}
