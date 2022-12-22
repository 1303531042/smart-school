package com.kun.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Data
@ApiModel("MeterBaseValue对象")
@NoArgsConstructor
@AllArgsConstructor
public class MeterBaseValue {
    @ApiModelProperty("采集时间")
    private Date collectTime;
    @ApiModelProperty("存储时间")
    private Date storageBasTime;
    @ApiModelProperty("参数值")
    private Double value;
}
