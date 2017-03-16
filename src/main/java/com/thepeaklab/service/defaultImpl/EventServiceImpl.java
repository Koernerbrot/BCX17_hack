package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.model.entity.Event;
import com.thepeaklab.persistence.model.entity.EventValue;
import com.thepeaklab.persistence.model.enums.EventType;
import com.thepeaklab.service.EventService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * created on 16/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class EventServiceImpl implements EventService {

    @Override
    public Event checkPastDataForEvents(Device device) {

        if (device == null) throw new InvalidParameterException();

        return new Event(EventType.ROAD_BUMP, new EventValue(1000, 1000));
    }
}
