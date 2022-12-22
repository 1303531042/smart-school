package com.kun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author KUN
 * @date 2022/12/21
 **/
@Data
@ApiModel("分析表对象")
@NoArgsConstructor
@AllArgsConstructor
public class Analyze {

    @ApiModelProperty("分析表id")
    private Integer id;

    @ApiModelProperty("建筑id")
    private Integer buildID;

    @ApiModelProperty("时间")
    private Date time;

    @ApiModelProperty("能源类型 0-水 1-电")
    private Integer energyType;

    @ApiModelProperty("分析类型 0-同比 1-环比")
    private Integer analyzeType;

    @ApiModelProperty("用能日期")
    private String dateStr;

    @ApiModelProperty("当前值")
    private Double nowValue;

    @ApiModelProperty("对比值")
    private Double lastValue;

    @ApiModelProperty("差额")
    private Double diffValue;

    @ApiModelProperty("比率")
    private Double ratioValue;
}
