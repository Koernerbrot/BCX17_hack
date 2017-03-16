package com.thepeaklab.web.controller;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.model.entity.Event;
import com.thepeaklab.service.DeviceService;
import com.thepeaklab.service.EventService;
import com.thepeaklab.service.VersionService;
import com.thepeaklab.web.dto.EventDto;
import com.thepeaklab.web.dto.SensorDataDto;
import com.thepeaklab.web.dto.SensorDataListDto;
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

    EventService eventService;

    public DeviceController(DeviceService deviceService, EventService eventService) {
        this.deviceService = deviceService;
        this.eventService = eventService;
    }

    @PutMapping("/{deviceUuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDevice(@PathVariable String deviceUuid) {

        log.info("createDevice() - API path /device/" + deviceUuid + " called");
        deviceService.createDevice(deviceUuid);
    }

    @PostMapping("/{deviceUuid}/data")
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto addSensorData(@PathVariable String deviceUuid, @RequestBody SensorDataListDto dto) {

        log.info("addSensorData() - API path /device/" + deviceUuid + "/data called");
        Device device = deviceService.addSensorData(deviceUuid, dto);

        Event event = eventService.checkPastDataForEvents(device);

        if (event != null) {
            return EventDto.create(event);
        }

        return null;
    }

}
