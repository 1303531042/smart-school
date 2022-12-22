package com.kun.service.impl;

import com.kun.domain.MeterBaseValue;
import com.kun.mapper.MeterBaseValueMapper;
import com.kun.service.MeterBaseValueService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Service
public class MeterBaseValueServiceImpl implements MeterBaseValueService {
    @Autowired
    private MeterBaseValueMapper meterBaseValueMapper;

    @Override
    public List<MeterBaseValue> queryAllByTableName(@Param("meterID") Integer meterID) {
        return meterBaseValueMapper.selectAllByTableName(meterID);

    }
}
