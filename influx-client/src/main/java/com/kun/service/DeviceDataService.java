package com.kun.service;

import com.kun.domain.DeviceData;

import java.util.List;

/**
 * @author KUN
 * @date 2022/12/14
 **/
public interface DeviceDataService {

    boolean saveDeviceDataList(List<DeviceData> deviceDataList, int meterID, int groupID, int size);


}
