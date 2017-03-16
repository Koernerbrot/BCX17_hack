package com.thepeaklab.web.dto;

import com.thepeaklab.persistence.model.entity.Event;
import com.thepeaklab.persistence.model.enums.EventType;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public class EventDto {

    EventType type;

    double lat;

    double lng;

    public EventDto() {
        // nothing to do
    }

    public EventDto(EventType type, double lat, double lng) {
        this.type = type;
        this.lat = lat;
        this.lng = lng;
    }

    public static EventDto create(Event model) {
        return new EventDto(model.getType(), model.getValue().getLat(), model.getValue().getLng());
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
