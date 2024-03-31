package com.gfj.plantpal.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gefangjie
 * @date 2021-06-07
 * description: 这个是土壤传感器实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SensorSoilEntropyData extends SensorBaseData {
    //土壤导电率
    @JsonProperty("Conductivity")
    private Double conductivity;
    //土壤PH值
    @JsonProperty("PH")
    private Double ph;
    //土壤含氮量
    @JsonProperty("N")
    private Double n;
    //土壤含磷量
    @JsonProperty("P")
    private Double p;
    //土壤含钾量
    @JsonProperty("K")
    private Double k;
}
