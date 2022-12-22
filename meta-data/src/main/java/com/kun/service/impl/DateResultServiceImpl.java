package com.kun.service.impl;

import com.kun.domain.DateResult;
import com.kun.domain.DayResult;
import com.kun.domain.prams.ResultPrams;
import com.kun.mapper.DateResultMapper;
import com.kun.service.DateResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/22
 **/
@Service
public class DateResultServiceImpl implements DateResultService {
    @Autowired
    private DateResultMapper dateResultMapper;

    @Override
    public List<DateResult> queryListByTime(ResultPrams prams) {
        String tableSuffix = null;
        switch (prams.getQueryType()
        ) {
            case 0:
                tableSuffix = "day";
                break;
            case 1:
            case 2:
                tableSuffix = "month";
                break;
            case 3:
                tableSuffix = "year";
                break;
            default:
                break;

        }
        return dateResultMapper.selectListByTime(prams, tableSuffix);
    }
}
