package com.kun.service.impl;

import com.kun.domain.*;
import com.kun.domain.prams.AnalyzePrams;
import com.kun.domain.prams.BasePrams;
import com.kun.domain.prams.LimitPrams;
import com.kun.domain.prams.ResultPrams;
import com.kun.domain.vo.AnalyzeOptionVo;
import com.kun.domain.vo.OptionVO;
import com.kun.service.OptionService;
import com.kun.util.DateUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KUN
 * @date 2022/12/19
 **/
@Service
public class OptionServiceImpl implements OptionService {
    @Override
    public OptionVO createDateResultsOption(List<DateResult> dateResults, ResultPrams prams) {
        OptionVO option = new OptionVO();
        setOptionBaseInfo(dateResults, prams, option);
        List<Double> valueList = new ArrayList<>();
        for (DateResult dateResult : dateResults) {
            valueList.add(dateResult.getValue());
        }
        option.setXValues(valueList.toArray(new Double[0]));
        setDateResultOptionTitle(prams,option);
        setOptionYUnit(prams.getEnergyType(), option);
        return option;
    }

    @Override
    public OptionVO createCeiOption(List<DateResult> dateResults, ResultPrams prams) {
        OptionVO option = new OptionVO();
        setOptionBaseInfo(dateResults, prams, option);
        option.setYUnit("co2");
        option.setTitle("");
        List<Double> valueList = new ArrayList<>();
        for (DateResult dateResult : dateResults) {
            DecimalFormat format = new DecimalFormat("#.00");
            valueList.add(Double.parseDouble(format.format(dateResult.getValue())));
        }
        option.setXValues(valueList.toArray(new Double[0]));

        return option;
    }



    @Override
    public OptionVO createPowerOption(List<PowerResult> powerResults, PowerPrams prams) {
        List<Double> values = new ArrayList<>();
        List<String> x = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        for (PowerResult result : powerResults) {
            x.add(sdf.format(result.getTime()));
            values.add(result.getValue());
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int size = powerResults.size();
        OptionVO option = new OptionVO();
        option.setXValues(values.toArray(new Double[0]));
        option.setXNames(x.toArray(new String[0]));
        option.setYUnit("总有功功率(KW)");
        option.setTitle(sdf1.format(prams.getStartTime()) + "~" + sdf1.format(prams.getStopTime())  + prams.getBuildName() + " 负荷查询");
        option.setInterval(size/10);
        return option;
    }

    @Override
    public OptionVO createLimitOption(LimitPrams limitPrams, List<LimitEnergy> limitEnergies) {
        List<String> xNames = new ArrayList<>();
        List<Double> xValues = new ArrayList<>();
        for (LimitEnergy limitEnergy : limitEnergies) {
            xValues.add(limitEnergy.getXValue());
            xNames.add(limitEnergy.getXName());
        }
        OptionVO option = new OptionVO();
        option.setXNames(xNames.toArray(new String[0]));
        option.setXValues(xValues.toArray(new Double[0]));
        option.setInterval(0);
        setLimitOptionTitle(option, limitPrams);
        setOptionYUnit(limitPrams.getEnergyType(), option);
        return option;
    }

    @Override
    public OptionVO createAnalyzeOption(List<Analyze> analyzeList, AnalyzePrams prams) {

        List<String> xNames = new ArrayList<>();
        List<Double> xValues = new ArrayList<>();
        List<Double> xValues1 = new ArrayList<>();
        for (Analyze analyze : analyzeList) {
            xNames.add(analyze.getDateStr());
            xValues.add(analyze.getNowValue());
            xValues1.add(analyze.getLastValue());
        }
        AnalyzeOptionVo option = new AnalyzeOptionVo();
        setAnalyzeOptionTitle(option, prams);
        setOptionYUnit(prams.getEnergyType(), option);
        option.setInterval(2);
        option.setXNames(xNames.toArray(new String[0]));
        option.setXValues(xValues.toArray(new Double[0]));
        option.setXValues1(xValues1.toArray(new Double[0]));
        return option;
    }


    public OptionVO createDayOption(List<DateResult> dateResults, BasePrams prams, OptionVO option) {
        option.setXNames(DateUtils.getDateByWholePoint().toArray(new String[0]));
        option.setInterval(1);
        return option;
    }
    private OptionVO createWeekendOption(List<DateResult> dateResults, BasePrams prams, OptionVO option) {
        option.setXNames(DateUtils.getCurrentWeekDate().toArray(new String[0]));
        option.setInterval(0);
        return option;
    }

    public OptionVO createMonthOption(List<DateResult> dateResults, BasePrams prams, OptionVO option) {
        option.setXNames(DateUtils.getCurrentMonth().toArray(new String[0]));
        option.setInterval(2);
        return option;
    }

    public OptionVO createYearOption(List<DateResult> dateResults, BasePrams prams, OptionVO option) {
        option.setXNames(DateUtils.getCurrentYear().toArray(new String[0]));
        option.setInterval(1);
        return option;
    }
    private void setOptionBaseInfo(List<DateResult> dateResults, BasePrams prams,OptionVO option){
        switch (prams.getQueryType()) {
            case 0:
                option = createDayOption(dateResults, prams,option);
                break;
            case 1:
                option = createWeekendOption(dateResults, prams,option);
                break;
            case 2:
                option = createMonthOption(dateResults, prams,option);
                break;
            case 3:
                option = createYearOption(dateResults, prams,option);
                break;
            default:
                break;

        }
    }


    private void setOptionYUnit(int valueType,OptionVO option) {
        switch (valueType) {
            case 0:
                option.setYUnit("水(m³)");
                break;
            case 1:
                option.setYUnit("电(KWh)");
                break;
            case 2:
                option.setYUnit("总能耗(kgce)");
                break;
            case 3:
                option.setYUnit("co2");
                break;
            default:
                break;
        }
    }
    public void setLimitOptionTitle(OptionVO option, LimitPrams limitPrams) {
        StringBuilder builder = new StringBuilder();
        switch (limitPrams.getQueryType()) {
            case 0:
                builder.append("月");
                break;
            case 1:
                builder.append("年");
                break;
            default:
                break;
        }
        switch (limitPrams.getEnergyType()) {
            case 0:
                builder.append("用水量");
                break;
            case 1:
                builder.append("用电量");
                break;
            default:
                break;
        }
        switch (limitPrams.getLimitType()) {
            case 0:
                builder.append("节能");
                break;
            case 1:
                builder.append("超限");
                break;
            default:
                break;
        }
        builder.append("排名");
        option.setTitle(builder.toString());

    }
    public void setAnalyzeOptionTitle(OptionVO option,AnalyzePrams prams) {
        StringBuilder title = new StringBuilder();
        setOptionTitlePrefix(title,prams);
        switch (prams.getAnalyzeType()) {
            case 0:
                title.append("同比分析");
                break;
            case 1:
                title.append("环比分析");
                break;
            default:
                break;
        }
        option.setTitle(title.toString());
    }
    private void setDateResultOptionTitle(ResultPrams prams,OptionVO option) {
        StringBuilder title = new StringBuilder();
        setOptionTitlePrefix(title,prams);
        switch (prams.getEnergyType() ) {
            case 0:
                title.append("水");
                break;
            case 1:
                title.append("电");
                break;
            case 2:
                title.append("总能耗");
                break;
            default:
                break;
        }
        option.setTitle(title.toString());
    }

    private void setOptionTitlePrefix(StringBuilder title, BasePrams prams) {
        String[] strings = null;
        switch (prams.getQueryType()) {
            case 0:
                strings = DateUtils.getDayFirstAndLast(prams.getStartTime());
                break;
            case 1:
                strings = DateUtils.getWeekendFirstAndLast(prams.getStartTime());
                break;
            case 2:
                strings = DateUtils.getMonthFirstAndLast(prams.getStartTime());
                break;
            case 3:
                strings = DateUtils.getYearFirstAndLast(prams.getStartTime());
                break;
            default:
                break;
        }
        if (strings != null) {
            title.append(strings[0]);
            title.append("~");
            title.append(strings[1]);
            title.append(" ").append(prams.getBuildName()).append(" ");
        }

    }


}
