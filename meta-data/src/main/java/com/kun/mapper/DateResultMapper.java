package com.kun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kun.domain.DateResult;
import com.kun.domain.prams.ResultPrams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/22
 **/
@Mapper
public interface DateResultMapper extends BaseMapper<DateResult> {
    List<DateResult> selectListByTime(@Param("prams")ResultPrams prams, @Param("tableSuffix") String tableSuffix);
}
