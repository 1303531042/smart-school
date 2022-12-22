package com.kun.domain.prams;

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
@ApiModel("限制表查询参数对象")
@NoArgsConstructor
@AllArgsConstructor
public class LimitPrams {
    @ApiModelProperty("能源类型 0-水 1-电")
    private Integer energyType;
    @ApiModelProperty("查询类型 0-月 1-年")
    private Integer queryType;
    @ApiModelProperty("限制类型 0-节能 1-超限")
    private Integer limitType;
}
