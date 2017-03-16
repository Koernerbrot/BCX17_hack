package com.thepeaklab.service;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.web.dto.SensorDataDto;
import com.thepeaklab.web.dto.SensorDataListDto;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface DeviceService {

    Device createDevice(String uuid);

    Device addSensorData(String uuid, SensorDataListDto dto);

}
