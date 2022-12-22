package com.kun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kun.domain.MeterInfoNew;
import com.kun.mapper.MeterInfoNewMapper;
import com.kun.service.MeterInfoNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Service
public class MeterInfoNewServiceImpl implements MeterInfoNewService {

    @Autowired
    private MeterInfoNewMapper meterInfoNewMapper;

    @Override
    public List<MeterInfoNew> queryAll() {
        return meterInfoNewMapper.selectList(new QueryWrapper<>());
    }
}
