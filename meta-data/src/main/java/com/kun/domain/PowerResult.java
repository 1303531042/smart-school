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
 * @date 2022/12/20
 **/
@Data
@ApiModel("负荷记录对象")
@TableName("power_result")
@NoArgsConstructor
@AllArgsConstructor
public class PowerResult {

    @TableId
    @ApiModelProperty("id")
    private Integer id;

    @TableField("build_id")
    @ApiModelProperty("建筑id")
    private Integer buildID;

    @TableField("time")
    @ApiModelProperty("记录时间")
    private Date time;


    @TableField("value")
    @ApiModelProperty("值")
    private Double value;
}
