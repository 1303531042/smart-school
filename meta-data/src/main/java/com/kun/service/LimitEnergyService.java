package com.kun.service;

import com.kun.domain.LimitEnergy;
import com.kun.domain.prams.LimitPrams;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/20
 **/
public interface LimitEnergyService {
    List<LimitEnergy> queryListByType(LimitPrams limitPrams);
}
