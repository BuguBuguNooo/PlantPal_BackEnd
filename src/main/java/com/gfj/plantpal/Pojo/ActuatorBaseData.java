package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是执行器的基础数据类，包含了执行器的基础信息
 */
@Data
public class ActuatorBaseData {
    //id
    private Integer id;
    //时间戳
    private Long timestamp;
    //设备名称
    @JsonProperty("Device")
    private String device;
    //执行器名称
    @JsonProperty("Actuator")
    private String actuator;
}
