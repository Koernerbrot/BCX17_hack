package com.thepeaklab.web.dto;

import com.thepeaklab.persistence.model.entity.Acceleration;

import javax.persistence.ManyToOne;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public class SensorDataDto {

    private Double positionLat;

    private Double positionLng;

    private Double speed;

    private Double heading;

    private Double accelerationX;

    private Double accelerationY;

    private Double accelerationZ;

    public SensorDataDto() {
        // nothing to do
    }

    public SensorDataDto(Double positionLat, Double positionLng, Double speed, Double heading, Double accelerationX, Double accelerationY, Double accelerationZ) {
        this.positionLat = positionLat;
        this.positionLng = positionLng;
        this.speed = speed;
        this.heading = heading;
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
        this.accelerationZ = accelerationZ;
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

    public Double getAccelerationX() {
        return accelerationX;
    }

    public void setAccelerationX(Double accelerationX) {
        this.accelerationX = accelerationX;
    }

    public Double getAccelerationY() {
        return accelerationY;
    }

    public void setAccelerationY(Double accelerationY) {
        this.accelerationY = accelerationY;
    }

    public Double getAccelerationZ() {
        return accelerationZ;
    }

    public void setAccelerationZ(Double accelerationZ) {
        this.accelerationZ = accelerationZ;
    }
}
