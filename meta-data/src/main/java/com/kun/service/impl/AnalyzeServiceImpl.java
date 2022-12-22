package com.kun.service.impl;

import com.kun.domain.Analyze;
import com.kun.domain.prams.AnalyzePrams;
import com.kun.mapper.AnalyzeMapper;
import com.kun.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/21
 **/
@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Autowired
    private AnalyzeMapper analyzeMapper;

    @Override
    public List<Analyze> queryListByTime(AnalyzePrams prams) {
        String tableSuffix = null;
        switch (prams.getQueryType()) {
            case 0:
                tableSuffix = "day";
                break;
            case 1:
                tableSuffix = "month";
                break;
            case 2:
                tableSuffix = "year";
                break;
            default:
                break;
        }

        return analyzeMapper.selectListByTime(prams, tableSuffix);
    }

}
