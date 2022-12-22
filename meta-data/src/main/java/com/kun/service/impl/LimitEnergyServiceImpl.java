package com.kun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kun.domain.LimitEnergy;
import com.kun.domain.prams.LimitPrams;
import com.kun.mapper.LimitEnergyMapper;
import com.kun.service.LimitEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/20
 **/
@Service
public class LimitEnergyServiceImpl implements LimitEnergyService {

    @Autowired
    private LimitEnergyMapper limitEnergyMapper;

    @Override
    public List<LimitEnergy> queryListByType(LimitPrams limitPrams) {
        return limitEnergyMapper.selectList(new QueryWrapper<LimitEnergy>()
                .eq("energy_type", limitPrams.getEnergyType())
                .eq("query_type", limitPrams.getQueryType())
                .eq("limit_type",limitPrams.getLimitType()));
    }
}
