package com.thepeaklab.service;

import com.thepeaklab.persistence.model.entity.Device;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface DeviceService {

    Device createDevice(String uuid);

}
