package com.kun.domain.prams;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author KUN
 * @date 2022/12/19
 **/
@Data
@ApiModel("用能检测参数对象")
@NoArgsConstructor
@AllArgsConstructor
public class ResultPrams {
    @ApiModelProperty("查询起始时间")
    private Date startTime;
    @ApiModelProperty("查询终止时间")
    private Date stopTime;
    @ApiModelProperty("查询的建筑id")
    private Integer buildID;
    @ApiModelProperty("查询的建筑名")
    private String buildName;
    @ApiModelProperty("查询时间类型 0-day小时为单位 1-month天为单位 2-year年为单位")
    private Integer queryType;
    @ApiModelProperty("0-水 1-电 2-综合")
    private Integer valueType;


}
