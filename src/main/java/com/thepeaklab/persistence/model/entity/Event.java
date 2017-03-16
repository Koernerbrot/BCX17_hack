package com.thepeaklab.persistence.model.entity;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.thepeaklab.persistence.model.enums.EventType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Entity
public class Event extends BaseEntity {

    private EventType type;

    @OneToOne
    private EventValue value;

    public Event() {
        // default constructor
    }

    public Event(EventType type, EventValue value) {
        this.type = type;
        this.value = value;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventValue getValue() {
        return value;
    }

    public void setValue(EventValue value) {
        this.value = value;
    }
}
