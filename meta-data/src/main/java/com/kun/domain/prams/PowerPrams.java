package com.kun.domain.prams;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author KUN
 * @date 2022/12/20
 **/
@Data
@ApiModel("负荷监测参数对象")
@NoArgsConstructor
@AllArgsConstructor
public class PowerPrams {
    @ApiModelProperty("查询起始时间")
    private Date startTime;
    @ApiModelProperty("查询终止时间")
    private Date stopTime;
    @ApiModelProperty("查询的建筑id")
    private Integer buildID;
    @ApiModelProperty("查询的建筑名")
    private String buildName;
}
