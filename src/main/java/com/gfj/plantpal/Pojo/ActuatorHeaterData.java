package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是加热器传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorHeaterData extends ActuatorBaseData{
    //加热器的开关状态
    @JsonProperty("Heater")
    private Integer heater;
}
