package com.kun.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KUN
 * @date 2022/12/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionVO {
    /**
     * 标题
     */
    private String title;
    private String[] xNames;
    private Double[] xValues;
    private String yUnit;
    private Integer interval;

}
