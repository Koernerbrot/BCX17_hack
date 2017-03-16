package com.thepeaklab.persistence.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Entity
public class VehicleState extends BaseEntity {

    private Double positionLat;

    private Double positionLng;

    private Double speed;

    private Double heading;

    @ManyToOne(cascade = CascadeType.ALL)
    private Acceleration acceleration;

    public VehicleState() {

    }

    public VehicleState(Double positionLat, Double positionLng, Double speed, Double heading, Double accelerationX, Double accelerationY, Double accelerationZ) {
        this.positionLat = positionLat;
        this.positionLng = positionLng;
        this.speed = speed;
        this.heading = heading;
        this.acceleration = new Acceleration(accelerationX, accelerationY, accelerationZ);
    }

    public VehicleState(Double positionLat, Double positionLng, Double speed, Double heading, Acceleration acceleration) {
        this.positionLat = positionLat;
        this.positionLng = positionLng;
        this.speed = speed;
        this.heading = heading;
        this.acceleration = acceleration;
    }

    public Double getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(Double positionLat) {
        this.positionLat = positionLat;
    }

    public Double getPositionLng() {
        return positionLng;
    }

    public void setPositionLng(Double positionLng) {
        this.positionLng = positionLng;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }
}
