package com.kun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kun.domain.Analyze;
import com.kun.domain.prams.AnalyzePrams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/21
 **/
@Mapper
public interface AnalyzeMapper{
    List<Analyze> selectListByTime(@Param("prams") AnalyzePrams prams, @Param("tableSuffix") String tableSuffix);
}
