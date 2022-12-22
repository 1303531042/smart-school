package com.kun.service.impl;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.kun.service.DeviceDataService;
import com.kun.domain.DeviceData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
@Slf4j
@Service
public class DeviceDataServiceImpl implements DeviceDataService {
    @Autowired
    private InfluxDBClient influxDBClient;

    @Override
    public boolean saveDeviceDataList(List<DeviceData> deviceDataList, int meterID, int groupID, int size) {
        try (WriteApi writeApi = influxDBClient.makeWriteApi()) {
            writeApi.writeMeasurements(WritePrecision.S, deviceDataList);
            log.info(meterID+"------------------------>>第"+(groupID+1)+"段数据已入库-------------->>共"+size+"段");
            log.info("");
            return true;
        } catch (Exception e) {
            log.error(meterID+"------------------------>>第"+(groupID+1)+"段数据入库出现异常-------------->>共"+size+"段");
            e.printStackTrace();
        }
        return false;
    }
}
