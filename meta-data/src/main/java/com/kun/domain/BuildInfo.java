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
 * @date 2022/12/19
 **/
@Data
@ApiModel("建筑信息表对象")
@TableName("build_info")
@NoArgsConstructor
@AllArgsConstructor
public class BuildInfo {
    @TableId("id")
    @ApiModelProperty("建筑id")
    private Integer id;

    @TableField("parent_id")
    @ApiModelProperty("该建筑父id")
    private Integer parentID;

    @TableField("build_name")
    @ApiModelProperty("建筑名")
    private String buildName;


}
