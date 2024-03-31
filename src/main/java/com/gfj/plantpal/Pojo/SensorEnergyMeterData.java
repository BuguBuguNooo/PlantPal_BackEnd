package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是能耗传感器实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SensorEnergyMeterData extends SensorBaseData {
    //有效总电能
    @JsonProperty("ActiveTotalElectricalEnergy")
    private Double activeTotalElectricalEnergy;
    //电压
    @JsonProperty("Voltage")
    private Double voltage;
    //电流
    @JsonProperty("Current")
    private Double current;
    //有功功率
    @JsonProperty("ActivePower")
    private Double activePower;
    //无功功率
    @JsonProperty("ReactivePower")
    private Double reactivePower;
    //频率
    @JsonProperty("frequency")
    private Double frequency;
}
