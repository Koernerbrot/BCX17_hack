package com.thepeaklab.persistence.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Entity
public class App extends BaseEntity {

    private String uuid;

    @OneToMany
    private List<VehicleState> states;

    public App(String uuid, List<VehicleState> states) {
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
}
