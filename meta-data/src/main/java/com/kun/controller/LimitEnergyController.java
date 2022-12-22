package com.kun.controller;

import com.kun.domain.AjaxResult;
import com.kun.domain.LimitEnergy;
import com.kun.domain.prams.LimitPrams;
import com.kun.domain.vo.OptionVO;
import com.kun.service.LimitEnergyService;
import com.kun.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author KUN
 * @date 2022/12/20
 **/
@RestController
@RequestMapping("limit")
public class LimitEnergyController {
    @Autowired
    private LimitEnergyService limitEnergyService;

    @Autowired
    private OptionService optionService;

    @PostMapping("data")
    public AjaxResult getData(LimitPrams limitPrams) {
        List<LimitEnergy> limitEnergies = limitEnergyService.queryListByType(limitPrams);
        OptionVO option = optionService.createLimitOption(limitPrams,limitEnergies);

        return AjaxResult.success(option);
    }
}
