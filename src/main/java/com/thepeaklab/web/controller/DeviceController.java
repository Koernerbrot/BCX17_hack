package com.thepeaklab.web.controller;

import com.thepeaklab.service.DeviceService;
import com.thepeaklab.service.VersionService;
import com.thepeaklab.web.dto.VersionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PutMapping("/{deviceUuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDevice(@PathVariable String deviceUuid) {

        log.info("createDevice() - API path /device/ " + deviceUuid + " called");
        deviceService.createDevice(deviceUuid);

    }

}
