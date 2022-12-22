package com.kun.service;

import com.kun.domain.MeterBaseValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/

public interface MeterBaseValueService {
    List<MeterBaseValue> queryAllByTableName(@Param("meterID") Integer meterID);
}
