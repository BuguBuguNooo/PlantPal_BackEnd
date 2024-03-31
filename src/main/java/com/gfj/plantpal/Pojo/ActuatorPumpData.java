package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是水泵传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorPumpData extends ActuatorBaseData {
    //水泵的开关状态
    @JsonProperty("Pump")
    private Integer pump;
}
