package com.kun.service;

import com.kun.domain.prams.PowerPrams;
import com.kun.domain.PowerResult;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/20
 **/
public interface PowerResultService {
    List<PowerResult> queryListByTime(PowerPrams prams);
}
