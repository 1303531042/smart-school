package com.kun.domain.prams;

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
@ApiModel("分析表查询参数对象")
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzePrams extends BasePrams{
    @ApiModelProperty("分析类型 0-同比 1-环比")
    private Integer  analyzeType;

}
