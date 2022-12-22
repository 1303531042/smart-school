package com.kun.controller;

import com.kun.domain.*;
import com.kun.domain.prams.ResultPrams;
import com.kun.domain.vo.OptionVO;
import com.kun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author KUN
 * @date 2022/12/19
 **/
@RestController
@RequestMapping("energy")
public class EnergyMonitorController {

    @Autowired
    private DateResultService dateResultService;

    @Autowired
    private PowerResultService powerResultService;


    @Autowired
    private OptionService optionService;

    @PostMapping("GetData")
    public AjaxResult getResultList(@RequestBody ResultPrams prams) {
        Integer queryType = prams.getQueryType();
        if (queryType == null) {
            return AjaxResult.error("参数异常,queryType为null");
        }
        List<DateResult> dateResults = dateResultService.queryListByTime(prams);
        OptionVO option = optionService.createDateResultsOption(dateResults,prams);
        return AjaxResult.success(option);
    }
    @PostMapping("cei")
    public AjaxResult getCei(@RequestBody ResultPrams prams) {
        Integer queryType = prams.getQueryType();
        if (queryType == null) {
            return AjaxResult.error("参数异常,queryType为null");
        }
        List<DateResult> dateResults = dateResultService.queryListByTime(prams);
        DecimalFormat format = new DecimalFormat("#.00");
        for (DateResult dateResult : dateResults) {
            double value = Double.parseDouble(format.format(dateResult.getValue() * 0.785));
            dateResult.setValue(value);
        }
        OptionVO option = optionService.createCeiOption(dateResults,prams);
        return AjaxResult.success(option);
    }

    @PostMapping("powerData")
    public AjaxResult getPowerResult(PowerPrams prams) {
        List<PowerResult> powerResults = powerResultService.queryListByTime(prams);
        OptionVO option = optionService.createPowerOption(powerResults,prams);
        return AjaxResult.success(option);
    }


}
