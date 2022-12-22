package com.kun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KUN
 * @date 2022/12/20
 **/
@Data
@ApiModel("限制表信息对象")
@TableName("limit_Energy")
@NoArgsConstructor
@AllArgsConstructor
public class LimitEnergy {

    @TableId
    private Integer id;

    @TableField("energy_type")
    @ApiModelProperty("能源类型 0-水 1-电")
    private Integer energyType;

    @TableField("query_type")
    @ApiModelProperty("查询类型 0-月 1-年")
    private Integer queryType;

    @TableField("query_type")
    @ApiModelProperty("限制类型 0-节能 1-超限")
    private Integer limitType;

    @TableField("x_name")
    @ApiModelProperty("x刻度名")
    private String xName;

    @TableField("x_value")
    @ApiModelProperty("x值")
    private Double xValue;
}
