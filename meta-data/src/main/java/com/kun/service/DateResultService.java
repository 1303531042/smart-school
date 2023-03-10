package com.kun.service;

import com.kun.domain.DateResult;
import com.kun.domain.prams.ResultPrams;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/22
 **/
public interface DateResultService {
    List<DateResult> queryListByTime(ResultPrams prams);
}
