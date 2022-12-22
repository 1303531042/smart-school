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
 * @date 2022/12/22
 **/
@Data
@ApiModel("记录表对象")
@NoArgsConstructor
@AllArgsConstructor
public class DateResult {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("建筑id")
    private Integer buildID;

    @ApiModelProperty("记录时间")
    private Date startTime;

    @ApiModelProperty("设备类型 0-水 1-电  2-综合")
    private Integer type;

    @ApiModelProperty("值")
    private Double value;
}
