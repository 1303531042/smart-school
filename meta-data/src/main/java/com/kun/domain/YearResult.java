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
 * 日表
 * @author KUN
 * @date 2022/12/19
 **/
@Data
@ApiModel("年表对象")
@TableName("year_result")
@NoArgsConstructor
@AllArgsConstructor
public class YearResult {

    @TableId
    @ApiModelProperty("年表id")
    private Integer id;

    @TableField("build_id")
    @ApiModelProperty("建筑id")
    private Integer buildID;

    @TableField("start_time")
    @ApiModelProperty("记录时间")
    private Date startTime;

    @TableField("type")
    @ApiModelProperty("设备类型 0-水 1-电  2-综合")
    private Integer type;

    @TableField("value")
    @ApiModelProperty("值")
    private Double value;
}
