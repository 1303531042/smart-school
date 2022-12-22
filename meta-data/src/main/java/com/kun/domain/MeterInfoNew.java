package com.kun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KUN
 * @date 2022/12/13
 **/
@Data
@TableName("T_ST_MeterInfoNew")
@NoArgsConstructor
@AllArgsConstructor
public class MeterInfoNew {
    @TableId("F_MeterID")
    @ApiModelProperty("参数编号")
    private Integer meterID;

    @TableField("F_MeterID")
    @ApiModelProperty("参数名称")
    private String meterName;

    @TableField("F_BuildID")
    @ApiModelProperty("对应建筑ID")
    private Integer buildID;

    @TableField("F_EnergyItemID")
    @ApiModelProperty("能耗编码")
    private String energyItemID;

    @TableField("F_MonitorID")
    @ApiModelProperty("所属仪表")
    private Integer monitorID;

    @TableField("F_State")
    @ApiModelProperty("启用状态 1：启用 0：停用")
    private Integer state;

    @TableField("F_IsReal")
    @ApiModelProperty("是否实量;1：实时量，如，电流、电压、功率 0：累积量，如，有功总电量，比实时量多存在小时、日、月、年汇")
    private Integer isReal;

}
