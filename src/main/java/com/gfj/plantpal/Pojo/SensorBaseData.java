package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是传感器基础数据类
 */
@Data
public class SensorBaseData {
    //id是数据的唯一标识
    private Long id;
    //时间戳
    private long timestamp;
    //设备名称
    @JsonProperty("Device")
    private String device;
    //传感器名称
    @JsonProperty("Sensor")
    private String sensor;
}
