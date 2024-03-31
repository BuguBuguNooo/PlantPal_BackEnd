package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是LED灯传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorLEDData extends ActuatorBaseData {
    //LED的开关状态
    @JsonProperty("LED")
    private Integer led;
}
