package com.kun.controller;

import com.kun.domain.AjaxResult;
import com.kun.domain.Analyze;
import com.kun.domain.prams.AnalyzePrams;
import com.kun.domain.vo.OptionVO;
import com.kun.service.AnalyzeService;
import com.kun.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KUN
 * @date 2022/12/21
 **/
@RestController
@RequestMapping("analyze")
public class AnalyzeController {
    @Autowired
    private AnalyzeService analyzeService;

    @Autowired
    private OptionService optionService;

    @RequestMapping("data")
    public AjaxResult getData(AnalyzePrams prams) {
        List<Analyze> analyzeList = analyzeService.queryListByTime(prams);
        OptionVO option = optionService.createAnalyzeOption(analyzeList, prams);
        Map<String, Object> map = new HashMap<>();
        map.put("analyzeList", analyzeList);
        map.put("option", option);
        return AjaxResult.success(map);
    }
}
