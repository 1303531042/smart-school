package com.kun.mapper;

import com.kun.domain.MeterBaseValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Mapper
public interface MeterBaseValueMapper {
    List<MeterBaseValue> selectAllByTableName(@Param("meterID") Integer meterID);
}
