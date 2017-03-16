package com.thepeaklab.persistence.model.entity;

import javax.persistence.Entity;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Entity
public class StreetDamage extends BaseEntity {

    private Double lat;

    private Double lng;

    private int weight;

    public StreetDamage() {
        // nothing to do
    }

    public StreetDamage(Double lat, Double lng, int weight) {
        this.lat = lat;
        this.lng = lng;
        this.weight = weight;
    }

    public StreetDamage(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}