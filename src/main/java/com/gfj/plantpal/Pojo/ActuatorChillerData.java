package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是冷水机传感器实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActuatorChillerData extends ActuatorBaseData {
    //冷却器的开关状态
    @JsonProperty("Chiller")
    private Integer chiller;
}
