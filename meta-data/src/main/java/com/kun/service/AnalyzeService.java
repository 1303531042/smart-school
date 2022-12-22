package com.kun.service;

import com.kun.domain.Analyze;
import com.kun.domain.prams.AnalyzePrams;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/21
 **/
public interface AnalyzeService {
    List<Analyze> queryListByTime(AnalyzePrams prams);
}
