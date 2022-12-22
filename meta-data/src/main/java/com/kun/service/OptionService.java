package com.kun.service;

import com.kun.domain.*;
import com.kun.domain.prams.AnalyzePrams;
import com.kun.domain.prams.LimitPrams;
import com.kun.domain.prams.ResultPrams;
import com.kun.domain.vo.AnalyzeOptionVo;
import com.kun.domain.vo.OptionVO;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/19
 **/
public interface OptionService {


    OptionVO createCeiOption(List<DateResult> dateResults, ResultPrams prams);

    OptionVO createPowerOption(List<PowerResult> powerResults, PowerPrams prams);

    OptionVO createLimitOption(LimitPrams limitPrams, List<LimitEnergy> limitEnergies);

    OptionVO createAnalyzeOption(List<Analyze> analyzeList, AnalyzePrams prams);

    OptionVO createDateResultsOption(List<DateResult> dateResults, ResultPrams prams);

}
