package com.thepeaklab.web.dto;

import com.thepeaklab.persistence.model.enums.EventType;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public class EventDto {

    EventType type;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
