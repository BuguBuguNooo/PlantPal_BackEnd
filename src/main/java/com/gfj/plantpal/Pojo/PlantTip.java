package com.gfj.plantpal.Pojo;

import lombok.Data;

/**
 * @author gefangjie
 */
@Data
public class PlantTip {
    //贴士id
    private Integer tipId;
    //贴士发起时间
    private String date;
    //贴士标题
    private String summary;
    //贴士URl地址
    private String link;
}
