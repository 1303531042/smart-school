package com.kun.controller;

import com.google.common.collect.Lists;
import com.kun.domain.DeviceData;
import com.kun.domain.MeterBaseValue;
import com.kun.domain.MeterInfoNew;
import com.kun.service.DeviceDataService;
import com.kun.service.MeterBaseValueService;
import com.kun.service.MeterInfoNewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Slf4j
@RestController
@RequestMapping("meta")
public class MeteDataController {
    @Autowired
    private MeterBaseValueService meterBaseValueService;
    @Autowired
    private MeterInfoNewService meterInfoNewService;
    @Autowired
    private DeviceDataService deviceDataService;

    @RequestMapping("test")
    public void a() {
        try {
            List<MeterInfoNew> meterInfoNews = meterInfoNewService.queryAll();
            for (MeterInfoNew meterInfoNew : meterInfoNews) {
                int meterID = meterInfoNew.getMeterID();
                List<MeterBaseValue> meterBaseValues = null;
                try {
                    meterBaseValues = meterBaseValueService.queryAllByTableName(meterID);
                } catch (Exception e) {
                    log.info(meterID+"========================================>该参数数据表不存在");
                    continue;
                }
                List<DeviceData> deviceDataList = new ArrayList<>();
                for (MeterBaseValue meterBaseValue : meterBaseValues) {
                    DeviceData deviceData = new DeviceData();
                    deviceData.setBuildID(meterInfoNew.getBuildID());
                    deviceData.setMeterID(meterInfoNew.getMeterID());
                    deviceData.setMonitorID(meterInfoNew.getMonitorID());
                    deviceData.setCreateTime(meterBaseValue.getCollectTime().toInstant());
                    deviceData.setValue(meterBaseValue.getValue());
                    deviceDataList.add(deviceData);
                }
                List<List<DeviceData>> lists = Lists.partition(deviceDataList, 5000);
                int size = lists.size();
                for (int i = 0; i < size; i++) {
                    deviceDataService.saveDeviceDataList(lists.get(i), meterID,i,size);
                }
            }
        } catch (Exception e) {
            log.error("============================================>>程序出错退出");
        }

    }

}
