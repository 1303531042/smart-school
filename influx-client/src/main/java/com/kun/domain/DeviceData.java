package com.kun.domain;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.Instant;


/**
 * @author KUN
 * @date 2022/12/14
 **/
@Data
@Measurement(name = "dev")
@ApiModel("DeviceData对象")
public class DeviceData {
    @Column(tag = true)
    @ApiModelProperty("对应建筑ID")
    private Integer buildID;

    @Column(tag = true)
    @ApiModelProperty("设备编号")
    private Integer monitorID;

    @Column(tag = true)
    @ApiModelProperty("参数编号")
    private Integer meterID;

    @Column(timestamp = true)
    @ApiModelProperty("采集时间")
    private Instant createTime;

    @Column
    @ApiModelProperty("采集值")
    private Double value;


}
