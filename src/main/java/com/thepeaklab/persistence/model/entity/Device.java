package com.thepeaklab.persistence.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Entity
public class Device extends BaseEntity {

    private String uuid;

    @OneToMany
    private List<VehicleState> states;

    @OneToMany
    private List<Event> events;

    public Device(String uuid) {
        this(uuid, new ArrayList<>());
    }

    public Device(String uuid, List<VehicleState> states) {
        this.uuid = uuid;
        this.states = states;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<VehicleState> getStates() {
        return states;
    }

    public void setStates(List<VehicleState> states) {
        this.states = states;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
