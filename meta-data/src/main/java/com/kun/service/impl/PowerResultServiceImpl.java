package com.kun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kun.domain.prams.PowerPrams;
import com.kun.domain.PowerResult;
import com.kun.mapper.PowerResultMapper;
import com.kun.service.PowerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/20
 **/
@Service
public class PowerResultServiceImpl implements PowerResultService {
    @Autowired
    private PowerResultMapper powerResultMapper;
    @Override
    public List<PowerResult> queryListByTime(PowerPrams prams) {
        return powerResultMapper.selectList(new QueryWrapper<PowerResult>()
                .eq("build_id", prams.getBuildID())
                .between("time", prams.getStartTime(), prams.getStopTime()));
    }
}
