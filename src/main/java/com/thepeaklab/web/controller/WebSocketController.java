package com.thepeaklab.web.controller;

import com.thepeaklab.persistence.model.enums.EventType;
import com.thepeaklab.web.dto.EventDto;
import com.thepeaklab.web.dto.SensorDataDto;
import com.thepeaklab.web.dto.ValueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Controller
public class WebSocketController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/data/{deviceUuid}")
    @SendTo("/devices/{deviceUuid}/events")
    public EventDto getDataAndSendEvent(@DestinationVariable String deviceUuid, ValueDto data) throws Exception {

        log.info("getDataAndSendEvent() - got data " + data.getValue());

        return new EventDto(EventType.ROAD_BUMP, 1000, 1000);
    }
}
