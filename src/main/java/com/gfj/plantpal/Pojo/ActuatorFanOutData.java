package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是内风扇传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorFanOutData extends ActuatorBaseData{
    //外风扇的开关状态
    @JsonProperty("Fan")
    private Integer fan;
}
