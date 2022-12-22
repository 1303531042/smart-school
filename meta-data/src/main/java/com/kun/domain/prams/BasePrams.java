package com.kun.domain.prams;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@ApiModel("基础参数对象")
@NoArgsConstructor
@AllArgsConstructor
public class BasePrams {
    @ApiModelProperty("建筑id")
    private Integer buildID;
    @ApiModelProperty("建筑名")
    private String buildName;
    @ApiModelProperty("查询起始时间")
    private Date startTime;
    @ApiModelProperty("查询终止时间")
    private Date stopTime;
    @ApiModelProperty("查询时间类型 0-day 1-weekend 2-month 3-year")
    private Integer queryType;
    @ApiModelProperty("能源类型 0-水 1-电 2-综合 3-碳")
    private Integer energyType;
}
